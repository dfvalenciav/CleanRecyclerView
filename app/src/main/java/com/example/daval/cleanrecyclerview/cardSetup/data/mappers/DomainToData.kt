package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardSetup.CardSetupEntity
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