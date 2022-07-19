package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.CardListAvailableEvent
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.CardListAvailableFragmentDirections
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.CardListAvailableViewModel
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.CardAvailableAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected.Adapter.CardSelectAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected.Adapter.ICardSelectListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListAvailableBinding
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListSelectedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardListSelectedFragment : BaseFragment<FragmentCardListSelectedBinding, CardListSelectedViewModel>(), ICardSelectListener {


    override val viewModel by viewModels<CardListSelectedViewModel> ()
    private lateinit var items : List<CardSetupPresentation>

    val args : CardListSelectedFragmentArgs by navArgs()
    private lateinit  var itemslist : List<CardSetupPresentation>

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentCardListSelectedBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemslist = args.cardSetupPresentation.toMutableList()
        viewModel.getCardSetupList()
        binding.materialButtonCardListSelec.setOnClickListener {
            val action = CardListSelectedFragmentDirections.actionCardListSelectedFragmentToCardListTrustDeviceFragment()
            binding.materialButtonCardListSelec.findNavController().navigate(action)
        }
    }

    fun setAdapter (items: List<CardSetupPresentation>){
        with(binding.recyclerViewCardListSelec) {
            adapter = CardSelectAdapter(this@CardListSelectedFragment)
            (adapter as? CardSelectAdapter)?.submitList(itemslist)
        }
    }

    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner){ event ->
            when (event) {
                is CardListSelectedEvent.ListCardSetup -> {
                    items = event.ls
                    setAdapter(items)
                }
            }

        }
    }

    override fun onClickCardSelect(datapassed: CardSetupPresentation) {
        TODO("Not yet implemented")
    }
}