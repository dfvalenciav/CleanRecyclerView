package com.example.daval.cleanrecyclerview.cardSetup.data.repository

import android.graphics.Color
import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.ICardListSetupRepository
import com.example.daval.cleanrecyclerview.cardSetup.data.local.ICardSetupDao
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.*
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*

class CardRepository (private val cardSetupDao: ICardSetupDao) : ICardListSetupRepository  {

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

    override suspend fun getCardListCarrousel(): List<CardCarrousel> {
        cardSetupDao.deleteCardCarrouselEntity()
        insertCardCarrousel(cardListCarrousel())
        return cardSetupDao.getCardCarrouselList().map { it.toCardCarrousel() }
    }

    override suspend fun insertCardCarrousel(cardCarrousel: List<CardCarrousel>) {
            cardSetupDao.insertCardCarrousel((cardCarrousel.map { it.toCardCarrouselEntity() }))
    }

    override suspend fun getListUser(): List<User> {
        TODO("Not yet implemented")
    }

    override suspend fun insertUsers(users: List<User>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getListUserDetail(): List<UserDetail> {
        TODO("Not yet implemented")
    }

    override suspend fun insertUserDetail(userDetail: List<UserDetail>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUserDetail(userDetail: UserDetail) {
        TODO("Not yet implemented")
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

    private fun cardListCarrousel () : List<CardCarrousel> = listOf (
        CardCarrousel("ic_favicon_copy_4_white","BBVA", "123456789087656787", "Valido hasta 09/25", "ic_visa_vector", "#FFBB86FC"),
        CardCarrousel("ic_favicon_copy_4_white","SANTANDER", "385569503998764530", "Valido hasta 01/26", "ic_mastercard_vector", "#FF3700B3"),
        CardCarrousel("ic_favicon_copy_4_white","CAIXA", "988544879087495038", "Valido hasta 04/24", "ic_visa_vector", "#000000"),
        CardCarrousel("ic_favicon_copy_4_white","SABADELL", "123456789087656787", "Valido hasta 09/25", "ic_visa_vector", "#FF018786"),
        CardCarrousel("ic_favicon_copy_4_white","BANKIA", "385569503998764530", "Valido hasta 01/26", "ic_mastercard_vector", "#e8c227"),
        CardCarrousel("ic_favicon_copy_4_white","BAKINTER", "988544879087495038", "Valido hasta 04/24", "ic_visa_vector", "#000C66"),
        CardCarrousel("ic_favicon_copy_4_white","DEUTSCHE BANK", "548753215488785654", "Valido hasta 04/24", "ic_visa_vector", "#EADDCA"),
        CardCarrousel("ic_favicon_copy_4_white","CAJAMAR", "988544879087495038", "Valido hasta 04/24", "ic_visa_vector", "#01579b"),
        )
}
