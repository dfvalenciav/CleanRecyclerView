package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.realm.*
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*

/**REALM*/
fun RCardSetup.toCardSetup() = CardSetup(type, number, preferred, amount, clientName, clientId)
fun List<RCardSetup>.toRListCardSetup() = map { data ->
    data.toCardSetup()}

fun RCardHomeTask.toCardHomeTask() = CardHomeTask(task, description, icon)
fun List<RCardHomeTask>.toRListCardHomeTask() =  map { data ->
    data.toCardHomeTask() }

fun RCardCarrousel.toCardCarrousel() = CardCarrousel(bankLogo,bankName, cardNumber, cardExpiration, cardFranchise, cardBackgroud)
fun List<RCardCarrousel>.toRListCardCarrouselTask() = map { data ->
    data.toCardCarrousel() }


/**MOBILE PAYMENT SETUP**/
fun RConfig.toConfig()=Config(title, message, image, backGround,  indicatorSwitch)

fun List<RConfig>.toListConfig() = map { data -> data.toConfig() }
