package com.example.daval.cleanrecyclerview.cardCarrousel.presentation.cardCarrousel

import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardCarrousel.domain.useCase.GetCardCarrouselUseCase
import com.example.daval.cleanrecyclerview.cardCarrousel.presentation.mappers.toListCardCarrouselPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardCarrouselViewModel  @Inject constructor(
    private val getCardCarrouselUseCase: GetCardCarrouselUseCase
): BaseViewModel<CardCarrouselEvent>() {
    fun getCardCarrouselList () {
        executeUseCase(
            {
                getCardCarrouselUseCase.execute()
            },
            {
                    getCardCarrouselUseCase ->
                getCardCarrouselUseCase.toListCardCarrouselPresentation()
                    .also {
                            presentationCardListCarrousel ->
                        _event.value = CardCarrouselEvent.ListCardCarrousel(presentationCardListCarrousel)
                    }
            }
        )
    }
}