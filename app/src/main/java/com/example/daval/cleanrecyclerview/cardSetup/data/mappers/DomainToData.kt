package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardCarrousel.CardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardSetup.CardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup


fun CardSetup.toCardSetupEntity() = CardSetupEntity ( type, number, preferred, amount, clientName, clientId)
fun List<CardSetup>.toListCardSetupEntity() = map { domain ->
    domain.toCardSetupEntity()
}

fun CardHomeTask.toCardHomeTaskEntity() = CardHomeTaskEntity (Taks, Description, Icon)
fun List<CardHomeTask>.toListCardHomeTaskEntity() = map {domain ->
    domain.toCardHomeTaskEntity()
}

fun CardCarrousel.toCardCarrouselEntity() = CardCarrouselEntity(BankLogo,BankName,CardNumber,CardExpiration,CardFranchise)
fun List<CardCarrousel>.toListCardCarrouselEntity()= map {domain ->
    domain.toCardCarrouselEntity()
}