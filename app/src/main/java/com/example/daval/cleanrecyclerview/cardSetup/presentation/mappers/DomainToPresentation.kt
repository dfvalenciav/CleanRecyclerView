package com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers

import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import kotlin.reflect.typeOf

fun CardSetup.toCardSetupPresention() = CardSetupPresentation (type, number,preferred)
fun List<CardSetup>.toListCardSetupPresentation() = map{
    domain -> domain.toCardSetupPresention()
}

fun CardHomeTask.toCardHomeOptionsPresentation() = CardHomeOptionsPresentation(Taks, Description, Icon)
fun List<CardHomeTask>.toListCardHomeOptionsPresentation() = map {
    domain -> domain.toCardHomeOptionsPresentation()
}