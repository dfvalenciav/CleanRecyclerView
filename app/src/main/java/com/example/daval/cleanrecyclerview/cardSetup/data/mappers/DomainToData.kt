package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import co.cristian.bizumdialog.data.local.entity.UserDetailRealm
import co.cristian.bizumdialog.data.local.entity.UserRealm
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardCarrousel.RCardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardHome.RCardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardSetup.RCardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardCarrousel.CardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardSetup.CardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import java.util.*


/**ROOM*/
fun CardSetup.toCardSetupEntity() = CardSetupEntity ( type, number, preferred, amount, clientName, clientId)
fun List<CardSetup>.toListCardSetupEntity() = map { domain ->
    domain.toCardSetupEntity()
}

fun CardHomeTask.toCardHomeTaskEntity() = CardHomeTaskEntity (Taks, Description, Icon)
fun List<CardHomeTask>.toListCardHomeTaskEntity() = map {domain ->
    domain.toCardHomeTaskEntity()
}

fun CardCarrousel.toCardCarrouselEntity() = CardCarrouselEntity(BankLogo,BankName,CardNumber,CardExpiration,CardFranchise, CardBackground, )
fun List<CardCarrousel>.toListCardCarrouselEntity()= map {domain ->
    domain.toCardCarrouselEntity()
}

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