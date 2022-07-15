package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.CardSetupAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.ICardSetupListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListAvailableBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardListAvailableFragment : BaseFragment<FragmentCardListAvailableBinding, CardListAvailableViewModel> (), ICardSetupListener {

    override val viewModel by viewModels<CardListAvailableViewModel> ()
    private lateinit var items : List<CardSetupPresentation>

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCardListAvailableBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCardSetupList()
        binding.materialButtonCardListAvail.setOnClickListener {
            Toast.makeText(requireContext(), "click", Toast.LENGTH_LONG).show()
        }
    }

    fun setAdapter (items: List<CardSetupPresentation>){
        with(binding.recyclerViewCardListAvial) {
            adapter = CardSetupAdapter(this@CardListAvailableFragment)
            (adapter as? CardSetupAdapter)?.submitList(items)
        }
    }

    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner){ event ->
            when (event) {
                is CardAvailableEvent.ListCardSetup -> {
                    items = event.ls
                    setAdapter(items)
                }
            }

        }
    }

    override fun onClickCardSetup(datapassed: CardSetupPresentation) {
        // TODO: navigation
        val action = CardListAvailableFragmentDirections.actionCardListAvailableFragmentToCardListSelectedFragment()
        binding.materialButtonCardListAvail.setOnClickListener {

            with(binding.materialButtonCardListAvail){
                findNavController().navigate(action)
                Log.d("test", "click made")

            }
        }
    }
}