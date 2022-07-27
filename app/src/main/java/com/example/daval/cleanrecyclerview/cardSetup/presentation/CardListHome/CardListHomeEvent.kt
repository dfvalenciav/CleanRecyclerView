package com.example.daval.cleanrecyclerview.cardSetup.presentation.CardListHome

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation

sealed class CardListHomeEvent {
    class ListCardHomeTask (val ls: List<CardHomeOptionsPresentation>) : CardListHomeEvent()
}
