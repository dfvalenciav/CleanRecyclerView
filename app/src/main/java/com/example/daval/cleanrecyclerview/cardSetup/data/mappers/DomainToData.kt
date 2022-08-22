package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.UserDetailRealm
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.UserRealm
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.RCardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.RCardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.RCardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import java.util.*


/**REALM*/
fun CardSetup.toRCardSetupEntity() = RCardSetupEntity (type, number, preferred, amount, clientName, clientId, UUID.randomUUID().mostSignificantBits)
fun List<CardSetup>.toRListCardSetupEntity() = map { domain ->
    domain.toRCardSetupEntity()
}

fun CardHomeTask.toRCardHomeTaskEntity() = RCardHomeTaskEntity (Taks, Description, Icon, UUID.randomUUID().mostSignificantBits)
fun List<CardHomeTask>.toRListCardHomeTaskEntity() = map {domain ->
    domain.toRCardHomeTaskEntity()
}

fun CardCarrousel.toRCardCarrouselEntity() = RCardCarrouselEntity(BankLogo,BankName,CardNumber,CardExpiration,CardFranchise, CardBackground, UUID.randomUUID().mostSignificantBits)
fun List<CardCarrousel>.toRListCardCarrouselEntity()= map {domain ->
    domain.toRCardCarrouselEntity()
}

/**MAPPERS DIALOG**/

fun User.toUserRealm() = UserRealm(name, lastName, numPhone, userImage, numAccount, age, UUID.randomUUID().mostSignificantBits)

fun List<User>.toListUser() = map { domain ->
    domain.toUserRealm()
}

fun UserDetail.toUserDetailRealm() =
    UserDetailRealm(name, userGarbageIcon.toString(), userSmallIcon.toString(), UUID.randomUUID().mostSignificantBits)

fun List<UserDetail>.toListUserDetailRealm() = map { domain ->
    domain.toUserDetailRealm()
}