package com.example.daval.cleanrecyclerview.cardSetup.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardCarrousel.CardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Room.entityCardSetup.CardSetupEntity


@Dao
interface ICardSetupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardSetup(cardList: List<CardSetupEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardHomeTask(cardListHomeTask: List<CardHomeTaskEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardCarrousel(cardListCarrousel: List<CardCarrouselEntity>)

    @Query("DELETE FROM CardSetupEntity")
    suspend fun delete()

    @Query("SELECT * FROM CardSetupEntity")
    suspend fun getCardSetupList(): List<CardSetupEntity>

    @Query("UPDATE CardSetupEntity SET preferred = :preferred WHERE id = :id")
    fun updateCardSetup(id: Int, preferred: String?): Int

    @Query("SELECT * FROM CardHomeTaskEntity")
    suspend fun getCardHomeList(): List<CardHomeTaskEntity>

    @Query ("DELETE FROM CardHomeTaskEntity")
    suspend fun deletecardHomeTaskEntity()

    @Query ("SELECT * FROM CardCarrouselEntity")
    suspend fun getCardCarrouselList() : List<CardCarrouselEntity>

    @Query("DELETE  FROM CardCarrouselEntity")
    suspend fun deleteCardCarrouselEntity()


}