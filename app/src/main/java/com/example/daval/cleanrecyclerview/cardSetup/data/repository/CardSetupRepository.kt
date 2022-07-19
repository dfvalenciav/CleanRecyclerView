package com.example.daval.cleanrecyclerview.cardSetup.data.repository

import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.ICardListSetupRepository
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entity.ICardSetupDao
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.toCardSetup
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.toCardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup

class CardSetupRepository (private val cardSetupDao: ICardSetupDao) : ICardListSetupRepository  {

    override suspend fun getCardList(): List<CardSetup> {
       cardSetupDao.delete()
        insertCardSetup(cardlistSetup())
        return cardSetupDao.getCardSetupList().map { it.toCardSetup() }

    }

    override suspend fun insertCardSetup(cardSetup: List<CardSetup>) {
        cardSetupDao.insertCardSetup((cardSetup.map { it.toCardSetupEntity() }))
    }


    override fun updateCard(card: CardSetup): Boolean {
        TODO("Not yet implemented")
    }

    private fun cardlistSetup (): List<CardSetup> = listOf(
        CardSetup("Tarjeta de crèdito", "123456789087656787",false,10000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de dèbito", "385569503998764530",false,20000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de dèbito", "129369503098574038",false,15000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de crèdito", "988544879087495038",false,2000,"Pedro Pèrez", 321567765)
    )


}