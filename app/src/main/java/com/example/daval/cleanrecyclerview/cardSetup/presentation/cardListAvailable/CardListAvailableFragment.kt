package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.CardAvailableAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.ICardAvailableListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListAvailableBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardListAvailableFragment : BaseFragment<FragmentCardListAvailableBinding, CardListAvailableViewModel> (), ICardAvailableListener {

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
            val selectedCard : Array<CardSetup> = arrayOf(
            CardSetup("Tarjeta de crèdito", "1234567890",false,10000,"Pedro Pèrez", 321567765),
            CardSetup("Tarjeta de dèbito", "3855695039",false,20000,"Pedro Pèrez", 321567765))
            val action = CardListAvailableFragmentDirections.actionCardListAvailableFragmentToCardListSelectedFragment(
                selectedCard
            )
            binding.materialButtonCardListAvail.findNavController().navigate(action)
        }
    }

    fun setAdapter (items: List<CardSetupPresentation>){
        with(binding.recyclerViewCardListAvial) {
            adapter = CardAvailableAdapter(this@CardListAvailableFragment)
            (adapter as? CardAvailableAdapter)?.submitList(items)
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

    override fun onClickCardAvailable(datapassed: CardSetupPresentation) {
        // TODO: navigation
    }
}