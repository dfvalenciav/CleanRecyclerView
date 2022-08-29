package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation

sealed class CardListSelectedEvent {
    class  ListCardSetup (val ls : List<CardSetupPresentation>) : CardListSelectedEvent()
}