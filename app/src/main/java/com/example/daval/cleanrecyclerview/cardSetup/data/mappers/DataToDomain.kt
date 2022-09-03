package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardCarrousel.data.models.RCardCarrousel
import com.example.daval.cleanrecyclerview.cardCarrousel.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.data.local.realm.*
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.TypeConfigEnum

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
fun RConfig.toConfig()=Config(position.toTypeConfigData() ,title, message, image, backGround,  indicatorSwitch)

fun List<RConfig>.toListConfig() = map { data -> data.toConfig() }

fun String.toTypeConfigData() = when(this){
    "TOUCH_ID" -> TypeConfigEnum.TOUCH_ID
    "PAGO_MOVIL" -> TypeConfigEnum.PAGO_MOVIL
    else -> TypeConfigEnum.NONE
}


/**Organization**/
fun ROrg.toOrg() = Org(name, code, phone, nit, city, employees )

fun List<ROrg>.toListOrg() = map { data ->
    data.toOrg()
}
