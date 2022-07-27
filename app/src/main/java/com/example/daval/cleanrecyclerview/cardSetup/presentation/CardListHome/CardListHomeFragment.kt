package com.example.daval.cleanrecyclerview.cardSetup.presentation.CardListHome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.CardListHome.Adapter.CardHomeAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.CardListHome.Adapter.ICardHomeListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.card_list_home_item.*
import kotlinx.android.synthetic.main.fragment_card_list_home.*

@AndroidEntryPoint
class CardListHomeFragment : BaseFragment<FragmentCardListHomeBinding, CardListHomeViewModel>(),
    ICardHomeListener {

    override val viewModel by viewModels<CardListHomeViewModel> ()
    private lateinit var items : List<CardHomeOptionsPresentation>


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentCardListHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCardHomeList()
    }

    fun setAdapter (items: List<CardHomeOptionsPresentation>){
        with(binding.recyclerViewHomeOptions) {
            adapter = CardHomeAdapter(this@CardListHomeFragment)
            (adapter as? CardHomeAdapter)?.submitList(items)
        }
    }

    override fun setListeners() {
        binding.switchMobile.setOnClickListener {
            if (switchMobile.isChecked) {
                val action =
                    CardListHomeFragmentDirections.actionCardListHomeFragmentToCardListAvailableFragment()
                binding.switchMobile.findNavController().navigate(action)
            }
        }
    }

    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner){ event ->
            when (event) {
                is CardListHomeEvent.ListCardHomeTask -> {
                    items = event.ls
                    setAdapter(items)
                }
            }

        }
    }

    override fun onClickCardHome(datapassed: CardHomeOptionsPresentation) {
        TODO("Not yet implemented")
    }


}