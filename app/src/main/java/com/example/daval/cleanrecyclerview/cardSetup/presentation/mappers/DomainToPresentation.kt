package com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers

import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation

fun CardSetup.toCardSetupPresention() = CardSetupPresentation (type, number,preferred)
fun List<CardSetup>.toListCardSetupPresentation() = map{
    domain -> domain.toCardSetupPresention()
}