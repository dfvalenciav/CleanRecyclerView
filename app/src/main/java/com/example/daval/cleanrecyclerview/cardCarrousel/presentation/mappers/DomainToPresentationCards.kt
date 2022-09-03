package com.example.daval.cleanrecyclerview.cardCarrousel.presentation.mappers

import com.example.daval.cleanrecyclerview.cardCarrousel.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardCarrousel.presentation.models.CardCarrouselPresentation


fun CardCarrousel.toCardCarrouselPresentation() = CardCarrouselPresentation(BankLogo, BankName, CardNumber, CardExpiration, CardFranchise, CardBackground)
fun List<CardCarrousel>.toListCardCarrouselPresentation() = map {
    domain -> domain.toCardCarrouselPresentation()
}
