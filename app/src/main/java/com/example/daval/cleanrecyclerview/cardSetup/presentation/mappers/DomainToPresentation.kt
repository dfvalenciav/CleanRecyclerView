package com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers

import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.*
import kotlin.reflect.typeOf

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


/***MAPPERS DIALOG***/

fun User.toUserPresentation() = UserPresentation(name, numPhone, userImage)

fun UserDetail.toUserDetailPresentation() = UserDetailPresentation(name,userGarbageIcon,userSmallIcon)

fun List<User>.toListUserPresentation() = map { domain ->
    domain.toUserPresentation()
}

fun List<UserDetail>.toListUserDetailPresentation() = map { domain ->
    domain.toUserDetailPresentation()
}

/*** MAPERS MOBILE PAYMENT***/
fun Config.toConfigPresentation() =
    ConfigPresentation(title, message, image, backGround, indicatorSwitch)

fun List<Config>.toListConfigPresentation()=map { domain ->
    domain.toConfigPresentation()
}