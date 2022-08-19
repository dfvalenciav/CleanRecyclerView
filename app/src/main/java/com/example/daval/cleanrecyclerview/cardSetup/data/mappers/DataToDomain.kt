package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardCarrousel.RCardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardHome.RCardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardSetup.RCardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardCarrousel.CardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardSetup.CardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup

/**ROOM*/
fun CardSetupEntity.toCardSetup() = CardSetup(type,number,preferred,amount,clientName,clientId)
fun List<CardSetupEntity>.toListCardSetup() = map { data ->
    data.toCardSetup()}

fun CardHomeTaskEntity.toCardHomeTaks() = CardHomeTask(Task, Description, Icon)
fun List<CardHomeTaskEntity>.toListCardHomeTask() =  map {data ->
    data.toCardHomeTaks() }

fun CardCarrouselEntity.toCardCarrousel() = CardCarrousel(BankLogo,BankName, CardNumber, CardExpiration, CardFranchise, CardBackgroud)
fun List<CardCarrouselEntity>.toListCardCarrouselTask() = map { data ->
    data.toCardCarrousel() }

/**REALM*/
fun RCardSetupEntity.toCardSetup() = CardSetup(type, number, preferred, amount, clientName, clientId)
fun List<RCardSetupEntity>.toRListCardSetup() = map { data ->
    data.toCardSetup()}

fun RCardHomeTaskEntity.toCardHomeTask() = CardHomeTask(task, description, icon)
fun List<RCardHomeTaskEntity>.toRListCardHomeTask() =  map {data ->
    data.toCardHomeTask() }

fun RCardCarrouselEntity.toCardCarrousel() = CardCarrousel(bankLogo,bankName, cardNumber, cardExpiration, cardFranchise, cardBackgroud)
fun List<RCardCarrouselEntity>.toRListCardCarrouselTask() = map { data ->
    data.toCardCarrousel() }
