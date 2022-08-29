package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.utils.Utils
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.CardAvailableAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.ICardListPreferred
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListAvailableBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardListAvailableFragment : BaseFragment<FragmentCardListAvailableBinding, CardListAvailableViewModel> (), ICardListPreferred {

    override val viewModel by viewModels<CardListAvailableViewModel> ()
    private var listCardsSelected: MutableList<CardSetupPresentation> = mutableListOf()
    private lateinit var items : List<CardSetupPresentation>
    private val util: Utils = Utils()

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCardListAvailableBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCardSetupList()
        listCardsSelected.clear()
    }

    private fun setAdapter (items: List<CardSetupPresentation>){
        with(binding.rvCardListAvailable) {
            adapter = CardAvailableAdapter(this@CardListAvailableFragment)
            (adapter as? CardAvailableAdapter)?.submitList(items)
        }
    }

    override fun setListeners() {
        binding.btnCardListAvailableContinue.setOnClickListener {
            if (listCardsSelected.isEmpty()){
                view?.let { value -> util.showSnack(value, requireContext(), getString(R.string.noCardListSetupSelected), getString(R.string.utilsHideSnackbar)) }
            } else {
                val action =
                    CardListAvailableFragmentDirections.actionCardListAvailableFragmentToCardListSelectedFragment(
                        listCardsSelected.toTypedArray()
                    )
                binding.btnCardListAvailableContinue.findNavController().navigate(action)
            }
        }
    }

    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner){ event ->
            when (event) {
                is CardListAvailableEvent.ListCardSetup -> {
                    items = event.ls
                    setAdapter(items)
                }
            }
        }
    }

    override fun addPreferredCard(datapassed: CardSetupPresentation) {
        listCardsSelected.add(datapassed)
    }
}