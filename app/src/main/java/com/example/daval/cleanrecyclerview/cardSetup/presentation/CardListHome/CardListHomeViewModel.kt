package com.example.daval.cleanrecyclerview.cardSetup.presentation.CardListHome

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardHomeTaksUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.SetCardSetupUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected.CardListSelectedEvent
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListCardHomeOptionsPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListCardSetupPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation
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
