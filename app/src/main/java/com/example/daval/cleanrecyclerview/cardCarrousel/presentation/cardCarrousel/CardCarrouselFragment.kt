package com.example.daval.cleanrecyclerview.cardCarrousel.presentation.cardCarrousel

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel
import androidx.fragment.app.viewModels
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardCarrousel.presentation.models.CardCarrouselPresentation
import com.example.daval.cleanrecyclerview.databinding.FragmentCardCarrouselBinding
import com.example.daval.cleanrecyclerview.utils.Utils
import com.google.android.material.card.MaterialCardView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_card_list_home.*


@AndroidEntryPoint
class CardCarrouselFragment : BaseFragment<FragmentCardCarrouselBinding, CardCarrouselViewModel>() {

    override val viewModel by viewModels<CardCarrouselViewModel> ()
    private lateinit var itemsCarrousel : List<CardCarrouselPresentation>

    var colors = intArrayOf(
        Color.parseColor("#FFBB86FC"),
        Color.parseColor("#FF3700B3"),
        Color.parseColor("#000000"),
        Color.parseColor("#FF018786"),
        Color.parseColor("#e8c227"),
        Color.parseColor("#000C66"),
        Color.parseColor("#EADDCA"),
        Color.parseColor("#01579b")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCardCarrouselList()
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentCardCarrouselBinding.inflate(inflater, container, false)

    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner){ event ->
            when (event) {
                is CardCarrouselEvent.ListCardCarrousel -> {
                    itemsCarrousel = event.ls_carrousel
                    setupCarousel()
                }
            }
        }
    }

    private fun setupCarousel() {
        val carousel = binding.carouselCards
        binding.motionLayout.visibility = View.VISIBLE
        binding.progressBarCarrouselCards.visibility = View.INVISIBLE
        val numCards = itemsCarrousel.size//colors.size
        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return numCards
            }
            override fun populate(view: View, index: Int) {
                binding.progressBarCarrouselCards.visibility= View.INVISIBLE
                binding.motionLayout.visibility = View.VISIBLE
                val indexCard = itemsCarrousel[index]
                val util = Utils()
                if (view is MaterialCardView) {
                    view.setBackgroundColor(colors[index])
                    textViewCardNumberOne.text = util.hideCardNumber(indexCard.CardNumber)
                    textViewCardNumberTwo.text = util.hideCardNumber(indexCard.CardNumber)
                    textViewCardNumberThree.text = util.hideCardNumber(indexCard.CardNumber)
                    textViewBankNameTwo.text = indexCard.BankName
                    textViewBankNameOne.text = indexCard.BankName
                    textViewBankNameThree.text = indexCard.BankName
                    textViewCardExpirationOne.text = indexCard.CardExpiration
                    textViewCardExpirationTwo.text = indexCard.CardExpiration
                    textViewCardExpirationThree.text = indexCard.CardExpiration
                    imageViewFranchise1.setImageResource(indexCard.CardFranchise)
                    imageViewFranchise2.setImageResource(indexCard.CardFranchise)
                    imageViewFranchise3.setImageResource(indexCard.CardFranchise)
                }
            }

            override fun onNewItem(index: Int) {
                val indexCard = itemsCarrousel[index]
                val util = Utils()
                if (view is MaterialCardView) {
                    (view as MaterialCardView).setBackgroundColor(colors[index])
                    textViewCardNumberOne.text = util.hideCardNumber(indexCard.CardNumber)
                    textViewCardNumberTwo.text = util.hideCardNumber(indexCard.CardNumber)
                    textViewCardNumberThree.text = util.hideCardNumber(indexCard.CardNumber)
                    textViewBankNameTwo.text = indexCard.BankName
                    textViewCardExpirationOne.text = indexCard.CardExpiration
                    textViewCardExpirationTwo.text = indexCard.CardExpiration
                    textViewCardExpirationThree.text = indexCard.CardExpiration
                    imageViewFranchise1.setImageResource(indexCard.CardFranchise)
                    imageViewFranchise2.setImageResource(indexCard.CardFranchise)
                    imageViewFranchise3.setImageResource(indexCard.CardFranchise)
                }
            }
        })
        //carousel.refresh()
    }
}