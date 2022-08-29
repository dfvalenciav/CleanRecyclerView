package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.realm.*
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import java.util.*


/**REALM*/
fun CardSetup.toRCardSetup() = RCardSetup (type, number, preferred, amount, clientName, clientId, UUID.randomUUID().mostSignificantBits)
fun List<CardSetup>.toRListCardSetup() = map { domain ->
    domain.toRCardSetup()
}

fun CardHomeTask.toRCardHomeTask() = RCardHomeTask (Taks, Description, Icon, UUID.randomUUID().mostSignificantBits)
fun List<CardHomeTask>.toRListCardHomeTask() = map { domain ->
    domain.toRCardHomeTask()
}

fun CardCarrousel.toRCardCarrousel() = RCardCarrousel(BankLogo,BankName,CardNumber,CardExpiration,CardFranchise, CardBackground, UUID.randomUUID().mostSignificantBits)
fun List<CardCarrousel>.toRListCardCarrouselEntity()= map {domain ->
    domain.toRCardCarrousel()
}

/** MAPPERS MOBILE PAYMENT**/
fun Config.toConfigRealm() =
    RConfig(type.toString(), title, message, image, backGround,  indicatorSwitch, UUID.randomUUID().mostSignificantBits)

fun List<Config>.toListConfigRealm() = map { domain ->
    domain.toConfigRealm()
}


/**Organization**/
fun Org.toOrgRealm() = ROrg ( name, code, phone, nit, city, employees, UUID.randomUUID().mostSignificantBits)

fun List<Org>.toListOrgRealm() = map { domain ->
    domain.toOrgRealm()
}