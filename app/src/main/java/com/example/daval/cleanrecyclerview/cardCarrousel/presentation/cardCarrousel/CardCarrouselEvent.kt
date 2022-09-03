package com.example.daval.cleanrecyclerview.cardCarrousel.presentation.cardCarrousel

import com.example.daval.cleanrecyclerview.cardCarrousel.presentation.models.CardCarrouselPresentation

sealed class CardCarrouselEvent {
    class ListCardCarrousel (val ls_carrousel: List<CardCarrouselPresentation>) : CardCarrouselEvent()
}
