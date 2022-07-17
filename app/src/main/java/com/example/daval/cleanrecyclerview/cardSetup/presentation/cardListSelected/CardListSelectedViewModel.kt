package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected

import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardSetupUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListCardSetupPresentation

class CardListSelectedViewModel constructor(
    private  val getCardSetupUseCase: GetCardSetupUseCase)
    : BaseViewModel<CardListSelectedEvent> (){
    fun getCardSetupList () {
        executeUseCase(
            {
                getCardSetupUseCase.execute()
            },
            {
                    getCardSetupUseCase ->
                getCardSetupUseCase.toListCardSetupPresentation()
                    .also {
                            presentationCardListSetup ->
                        _event.value = CardListSelectedEvent.ListCardSetup(presentationCardListSetup)
                    }
            }
        )
    }
}