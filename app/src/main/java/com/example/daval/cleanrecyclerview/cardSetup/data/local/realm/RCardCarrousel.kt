package com.example.daval.cleanrecyclerview.cardSetup.data.local.realm


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCardCarrousel(
    var bankLogo : String = "",
    var bankName: String = "",
    var cardNumber: String = "",
    var cardExpiration: String = "",
    var cardFranchise: String = "",
    var cardBackgroud: String = "",
    @PrimaryKey var id: Long = 0

) : RealmObject()