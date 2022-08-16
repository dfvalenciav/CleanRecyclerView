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
fun CardSetup.toCardSetupEntity() = CardSetupEntity ( type, number, preferred, amount, clientName, clientId)
fun List<CardSetup>.toListCardSetupEntity() = map { domain ->
    domain.toCardSetupEntity()
}

fun CardHomeTask.toCardHomeTaskEntity() = CardHomeTaskEntity (Taks, Description, Icon)
fun List<CardHomeTask>.toListCardHomeTaskEntity() = map {domain ->
    domain.toCardHomeTaskEntity()
}

fun CardCarrousel.toCardCarrouselEntity() = CardCarrouselEntity(BankLogo,BankName,CardNumber,CardExpiration,CardFranchise, CardBackground)
fun List<CardCarrousel>.toListCardCarrouselEntity()= map {domain ->
    domain.toCardCarrouselEntity()
}

/**REALM*/
fun CardSetup.toRCardSetupEntity() = RCardSetupEntity ()
fun List<CardSetup>.toRListCardSetupEntity() = map { domain ->
    domain.toRCardSetupEntity()
}

fun CardHomeTask.toRCardHomeTaskEntity() = RCardHomeTaskEntity ()
fun List<CardHomeTask>.toRListCardHomeTaskEntity() = map {domain ->
    domain.toRCardHomeTaskEntity()
}

fun CardCarrousel.toRCardCarrouselEntity() = RCardCarrouselEntity()
fun List<CardCarrousel>.toRListCardCarrouselEntity()= map {domain ->
    domain.toRCardCarrouselEntity()
}