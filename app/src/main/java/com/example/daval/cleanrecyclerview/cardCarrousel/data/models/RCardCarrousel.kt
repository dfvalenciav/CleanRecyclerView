package com.example.daval.cleanrecyclerview.cardCarrousel.data.models


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCardCarrousel(
    var bankLogo : Int = 0,
    var bankName: String = "",
    var cardNumber: String = "",
    var cardExpiration: String = "",
    var cardFranchise: Int = 0,
    var cardBackgroud: Int = 0,
    @PrimaryKey var id: Long = 0

) : RealmObject()