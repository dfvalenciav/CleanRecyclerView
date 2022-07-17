package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation

sealed class CardListAvailableEvent {
    class  ListCardSetup (val ls : List<CardSetupPresentation>) : CardListAvailableEvent()
}