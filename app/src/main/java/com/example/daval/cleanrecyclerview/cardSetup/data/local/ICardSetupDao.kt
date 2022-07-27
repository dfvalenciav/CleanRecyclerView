package com.example.daval.cleanrecyclerview.cardSetup.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardHome.CardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entityCardSetup.CardSetupEntity


@Dao
interface ICardSetupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardSetup(cardList: List<CardSetupEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardHomeTask(cardListHomeTask: List<CardHomeTaskEntity>)

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

}