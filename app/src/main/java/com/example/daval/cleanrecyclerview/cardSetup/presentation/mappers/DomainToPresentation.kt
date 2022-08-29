package com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers

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

fun CardCarrousel.toCardCarrouselPresentation() = CardCarrouselPresentation(BankLogo, BankName, CardNumber, CardExpiration, CardFranchise, CardBackground)
fun List<CardCarrousel>.toListCardCarrouselPresentation() = map {
    domain -> domain.toCardCarrouselPresentation()
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