package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome

import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardCarrouselUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardHomeTaksUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListCardCarrouselPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListCardHomeOptionsPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CardListHomeViewModel @Inject constructor(
    private val getCardHomeTaksUseCase: GetCardHomeTaksUseCase,
    private val getCardCarrouselUseCase: GetCardCarrouselUseCase
): BaseViewModel<CardListHomeEvent>() {
    fun getCardHomeList () {
        executeUseCase(
            {
            getCardHomeTaksUseCase.execute()
        },
            {
                getCardHomeTaksUseCase ->
                getCardHomeTaksUseCase.toListCardHomeOptionsPresentation()
                    .also {
                        presentationCardListHomeTaks ->
                        _event.value= CardListHomeEvent.ListCardHomeTask(presentationCardListHomeTaks)
                    }
            }
        )
    }

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
                        _event.value = CardListHomeEvent.ListCardCarrousel(presentationCardListCarrousel)
                    }
            }
        )
    }
}
