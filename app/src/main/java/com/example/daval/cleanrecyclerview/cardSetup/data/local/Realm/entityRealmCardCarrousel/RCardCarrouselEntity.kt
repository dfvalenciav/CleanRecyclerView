package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardCarrousel


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCardCarrouselEntity() : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var BankLogo : String = ""
    var BankName: String = ""
    var CardNumber: String = ""
    var CardExpiration: String = ""
    var CardFranchise: String = ""
    var CardBackgroud: String = ""

}