package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected

import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardSetupUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.SetCardSetupUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListCardSetupPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardListSelectedViewModel @Inject constructor(
    private  val setCardSetupUseCase: SetCardSetupUseCase)
    : BaseViewModel<CardListSelectedEvent> (){
    fun getCardSetupList () {
        executeUseCase(
            {
                setCardSetupUseCase.execute()
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