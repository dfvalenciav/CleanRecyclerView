package com.example.daval.cleanrecyclerview.cardSetup.data.repository

import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.ICardListSetupRepository
import com.example.daval.cleanrecyclerview.cardSetup.data.local.ICardSetupDao
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.toCardHomeTaks
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.toCardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.toCardSetup
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.toCardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
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

    override suspend fun getCardListHomeTask(): List<CardHomeTask> {
        cardSetupDao.deletecardHomeTaskEntity()
        insertCardHomeTask(cardlisthome())
        return cardSetupDao.getCardHomeList().map { it.toCardHomeTaks() }
    }

    override suspend fun insertCardHomeTask(cardHomeTask: List<CardHomeTask>) {
        cardSetupDao.insertCardHomeTask((cardHomeTask.map { it.toCardHomeTaskEntity() }))
    }


    private fun cardlistSetup (): List<CardSetup> = listOf(
        CardSetup("Tarjeta de crèdito", "123456789087656787",false,10000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de dèbito", "385569503998764530",false,20000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de dèbito", "129369503098574038",false,15000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de crèdito", "988544879087495038",false,2000,"Pedro Pèrez", 321567765)
    )

    private fun cardlisthome () : List<CardHomeTask> = listOf(
        CardHomeTask("Actividad", "Movimientos de la tarjeta", "ic_icon_tarjeta_actividad"),
        CardHomeTask("Pago seguro", "Actividad entre el 22/07/21 al 23/07/21", "ic_icon_tarjeta_pago_seguro"),
        CardHomeTask("Roaming", "Uso fuera de Europa desactivado", "ic_icon_tarjeta_roaming"),
        CardHomeTask("CVV Dinámico", "Pago seguro", "ic_icon_tarjeta_cvv_dinamico")
    )
}