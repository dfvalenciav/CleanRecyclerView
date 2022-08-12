package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardCarrousel


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCardCarrouselEntity(
    BankLogo: String,
    BankName: String,
    CardNumber: String,
    CardExpiration: String,
    CardFranchise: String,
    CardBackground: String
) : RealmObject() {
    @PrimaryKey
    val id: Int? = null
    val BankLogo : String = ""
    val BankName: String = ""
    val CardNumber: String = ""
    val CardExpiration: String = ""
    val CardFranchise: String = ""
    val CardBackgroud: String = ""

}