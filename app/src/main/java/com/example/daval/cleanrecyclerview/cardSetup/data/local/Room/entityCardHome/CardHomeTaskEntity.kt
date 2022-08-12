package com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardHome

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CardHomeTaskEntity (
    val Task : String,
    val Description: String,
    val Icon: String,
    @PrimaryKey
    val id: Int? = null,
        )