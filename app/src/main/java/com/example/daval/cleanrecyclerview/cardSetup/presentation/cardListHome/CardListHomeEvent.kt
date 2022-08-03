package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardCarrouselPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation

sealed class CardListHomeEvent {
    class ListCardHomeTask (val ls: List<CardHomeOptionsPresentation>) : CardListHomeEvent()

    class ListCardCarrousel (val ls_carrousel: List<CardCarrouselPresentation>) : CardListHomeEvent()
}
