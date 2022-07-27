package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardSetup.CardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup


    fun CardSetupEntity.toCardSetup() = CardSetup(type,number,preferred,amount,clientName,clientId)
    fun List<CardSetupEntity>.toListCardSetup() = map { data ->
        data.toCardSetup()}

    fun CardHomeTaskEntity.toCardHomeTaks() = CardHomeTask(Task, Description, Icon)
    fun List<CardHomeTaskEntity>.toListCardHomeTask() =  map {data ->
        data.toCardHomeTaks()
    }