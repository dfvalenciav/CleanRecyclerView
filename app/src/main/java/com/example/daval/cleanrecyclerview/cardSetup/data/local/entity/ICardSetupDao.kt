package com.example.daval.cleanrecyclerview.cardSetup.data.local.entity

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup

interface ICardSetupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardSetup(cardList: List<CardSetupEntity>)

    @Query("DELETE FROM CardSetupEntity")
    suspend fun delete()

    @Query("SELECT * FROM CardSetupEntity")
    suspend fun getCardSetupList(): List<CardSetupEntity>

    @Query("UPDATE CardSetupEntity SET preferred = :preferred WHERE id = :id")
    fun updateCardSetup(id: Int, preferred: String?): Int
}