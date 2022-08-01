package com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardCarrousel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardCarrouselEntity (
    val BankLogo : String,
    val BankName: String,
    val CardNumber: String,
    val CardExpiration: String,
    val CardFranchise: String,
    @PrimaryKey
    val id: Int? = null,
        )
