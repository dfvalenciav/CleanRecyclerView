package com.example.daval.cleanrecyclerview.cardSetup.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardCarrousel.CardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardSetup.CardSetupEntity


@Database(
    version = 2,
    entities = [CardSetupEntity::class, CardHomeTaskEntity::class, CardCarrouselEntity::class],
    exportSchema = true,

)
abstract class CardSetupDataBase : RoomDatabase () {
    abstract val dao : ICardSetupDao
}
