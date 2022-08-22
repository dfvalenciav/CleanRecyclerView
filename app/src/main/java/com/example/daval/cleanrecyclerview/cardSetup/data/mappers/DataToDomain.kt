package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.UserDetailRealm
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.UserRealm
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.RCardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.RCardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.RCardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.StateEnum

/**REALM*/
fun RCardSetupEntity.toCardSetup() = CardSetup(type, number, preferred, amount, clientName, clientId)
fun List<RCardSetupEntity>.toRListCardSetup() = map { data ->
    data.toCardSetup()}

fun RCardHomeTaskEntity.toCardHomeTask() = CardHomeTask(task, description, icon)
fun List<RCardHomeTaskEntity>.toRListCardHomeTask() =  map { data ->
    data.toCardHomeTask() }

fun RCardCarrouselEntity.toCardCarrousel() = CardCarrousel(bankLogo,bankName, cardNumber, cardExpiration, cardFranchise, cardBackgroud)
fun List<RCardCarrouselEntity>.toRListCardCarrouselTask() = map { data ->
    data.toCardCarrousel() }

/**DIALOG MAPERS*/

fun UserRealm.toUser() = User(name, lastName, numPhone, userImage, numAccount, age)

fun List<UserRealm>.toListUser() = map { data ->
    data.toUser()
}

fun UserDetailRealm.toUserDetail() = UserDetail(name, userGarbageIcon.toTypeData(), userSmallIcon.toTypeData())

fun List<UserDetailRealm>.toListUserDetail() = map{ data ->
    data.toUserDetail()
}

fun String.toTypeData() = when (this) {
    "FAILURE" -> StateEnum.FAILURE
    "CHECK" -> StateEnum.CHECK
    "GARBAGE" -> StateEnum.GARBAGE
    else -> StateEnum.TIME
}
