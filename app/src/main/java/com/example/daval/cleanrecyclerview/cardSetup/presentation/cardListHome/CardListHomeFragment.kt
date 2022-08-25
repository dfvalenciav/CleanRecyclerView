package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Carousel
import androidx.fragment.app.viewModels
import com.example.daval.cleanrecyclerview.utils.Utils
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome.Adapter.CardHomeAdapter
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome.Adapter.ICardHomeListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardCarrouselPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListHomeBinding
import com.google.android.material.card.MaterialCardView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_card_list_home.*

@AndroidEntryPoint
class CardListHomeFragment : BaseFragment<FragmentCardListHomeBinding, CardListHomeViewModel>(),
    ICardHomeListener {

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
        //setupCarousel()

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
                /*val action =
                    CardListHomeFragmentDirections.actionCardListHomeFragmentToCardListAvailableFragment()
                binding.switchMobile.findNavController().navigate(action)*/
            }
        }
    }

    override fun observe() {
        viewModel.event.observe(viewLifecycleOwner){ event ->
            when (event) {
                is CardListHomeEvent.ListCardHomeTask -> {
                    items = event.ls
                    setAdapter(items)
                    viewModel.getCardCarrouselList()
                }
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
                        imageViewFranchise1.setImageResource(resources.getIdentifier(indexCard.CardFranchise, "drawable","com.example.daval.cleanrecyclerview"))
                        imageViewFranchise2.setImageResource(resources.getIdentifier(indexCard.CardFranchise, "drawable","com.example.daval.cleanrecyclerview"))
                        imageViewFranchise3.setImageResource(resources.getIdentifier(indexCard.CardFranchise, "drawable","com.example.daval.cleanrecyclerview"))
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
                    imageViewFranchise1.setImageResource(resources.getIdentifier(indexCard.CardFranchise, "drawable","com.example.daval.cleanrecyclerview"))
                    imageViewFranchise2.setImageResource(resources.getIdentifier(indexCard.CardFranchise, "drawable","com.example.daval.cleanrecyclerview"))
                    imageViewFranchise3.setImageResource(resources.getIdentifier(indexCard.CardFranchise, "drawable","com.example.daval.cleanrecyclerview"))
                }
            }
        })
        carousel.refresh()
    }
}