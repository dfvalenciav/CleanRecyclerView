package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome.Adapter.CardHomeAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome.Adapter.ICardHomeListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardCarrouselPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListHomeBinding
import com.google.android.material.card.MaterialCardView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.card_list_home_item.*
import kotlinx.android.synthetic.main.fragment_card_list_home.*

@AndroidEntryPoint
class CardListHomeFragment : BaseFragment<FragmentCardListHomeBinding, CardListHomeViewModel>(),
    ICardHomeListener {

    var colors = intArrayOf(
        Color.parseColor("#81d4fa"),
        Color.parseColor("#4fc3f7"),
        Color.parseColor("#29b6f6"),
        Color.parseColor("#03a9f4"),
        Color.parseColor("#039be5"),
        Color.parseColor("#0288d1"),
        Color.parseColor("#0277bd"),
        Color.parseColor("#01579b")
    )

    override val viewModel by viewModels<CardListHomeViewModel> ()
    private lateinit var items : List<CardHomeOptionsPresentation>
    private lateinit var itemsCarrousel : List<CardCarrouselPresentation>


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentCardListHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCardHomeList()
        viewModel.getCardCarrouselList()
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
        viewModel.event2.observe(viewLifecycleOwner){ event ->
            when (event) {
                is CardListHomeEvent.ListCardHomeTask -> {
                    items = event.ls
                    setAdapter(items)
                }
            }
        }
        viewModel.event.observe(viewLifecycleOwner){event ->
            when(event){
             is CardListHomeEvent.ListCardCarrousel -> {
                 itemsCarrousel = event.ls_carrousel
                 setupCarousel()
             }
            }
        }
    }

    override fun onClickCardHome(datapassed: CardHomeOptionsPresentation) {
        TODO("Not yet implemented")
    }

    private fun setupCarousel() {
        val carousel = binding.carouselSnake ?: return
        val numCards = itemsCarrousel.size
        Toast.makeText(requireContext(),numCards, Toast.LENGTH_LONG).show()
        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return numCards
            }
            override fun populate(view: View, index: Int) {
                if (view is MaterialCardView) {
                    view.setBackgroundColor(colors[index])
                }
            }
            override fun onNewItem(index: Int) {
            }
        })
    }
}