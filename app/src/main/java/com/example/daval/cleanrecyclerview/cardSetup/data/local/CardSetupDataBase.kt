package com.example.daval.cleanrecyclerview.cardSetup.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardSetup.CardSetupEntity


@Database(
    entities = [CardSetupEntity::class, CardHomeTaskEntity::class],
    version = 1
)
abstract class CardSetupDataBase : RoomDatabase () {
    abstract val dao : ICardSetupDao
}
