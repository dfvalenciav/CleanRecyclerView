package com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardSetup

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardSetupEntity (
    val type: String,
    val number: String,
    val preferred: Boolean,
    val amount:Int,
    val clientName: String,
    val clientId: Int,
    @PrimaryKey
    val id: Int? = null,
)