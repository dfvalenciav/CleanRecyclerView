package com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers

import com.example.daval.cleanrecyclerview.cardCarrousel.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardCarrousel.presentation.models.CardCarrouselPresentation
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.*


fun CardSetup.toCardSetupPresention() = CardSetupPresentation (type, number,preferred)
fun List<CardSetup>.toListCardSetupPresentation() = map{
    domain -> domain.toCardSetupPresention()
}

fun CardHomeTask.toCardHomeOptionsPresentation() = CardHomeOptionsPresentation(Taks, Description, Icon)
fun List<CardHomeTask>.toListCardHomeOptionsPresentation() = map {
    domain -> domain.toCardHomeOptionsPresentation()
}



/*** MAPERS MOBILE PAYMENT***/
fun Config.toConfigPresentation() =
    ConfigPresentation(type, title, message, image, backGround, indicatorSwitch)

fun List<Config>.toListConfigPresentation()=map { domain ->
    domain.toConfigPresentation()
}


/**Organization**/
fun Org.toOrgPresentation() = OrgPresentation(name, code)

fun List<Org>.toListOrgPresentation() = map {
        domain -> domain.toOrgPresentation()
}