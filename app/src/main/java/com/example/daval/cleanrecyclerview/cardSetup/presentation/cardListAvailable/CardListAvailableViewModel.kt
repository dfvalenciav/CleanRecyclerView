package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable

import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardSetupUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListCardSetupPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CardListAvailableViewModel @Inject constructor(
    private val getCardSetupUseCase: GetCardSetupUseCase
) : BaseViewModel<CardAvailableEvent> (){
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
                        _event.value = CardAvailableEvent.ListCardSetup(presentationCardListSetup)
                    }
            }
        )
    }
}