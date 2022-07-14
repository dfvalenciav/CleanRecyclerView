package com.example.daval.cleanrecyclerview.cardSetup.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [CardSetupEntity::class],
    version = 1
)
abstract class CardSetupDataBase : RoomDatabase () {
    abstract val dao : ICardSetupDao
}
