package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome

import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardHomeTaksUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListCardHomeOptionsPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CardListHomeViewModel @Inject constructor(
    private val getCardHomeTaksUseCase: GetCardHomeTaksUseCase
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
}
