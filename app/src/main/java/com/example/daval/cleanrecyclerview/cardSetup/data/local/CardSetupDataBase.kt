package com.example.daval.cleanrecyclerview.cardSetup.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardCarrousel.CardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardSetup.CardSetupEntity


@Database(
    version = 2,
    entities = [CardSetupEntity::class, CardHomeTaskEntity::class, CardCarrouselEntity::class],
    exportSchema = true,

)
abstract class CardSetupDataBase : RoomDatabase () {
    abstract val dao : ICardSetupDao
}
