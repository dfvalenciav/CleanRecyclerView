package com.example.daval.cleanrecyclerview.cardSetup.data.repository

import android.content.Context
import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.IRealmDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.BizumDataBaseRealm
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardCarrousel.RCardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardHome.RCardHomeTaskEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardSetup.RCardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.*
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import dagger.hilt.android.qualifiers.ApplicationContext
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.kotlin.where
import javax.inject.Inject


class CardRealmRepository @Inject constructor(@ApplicationContext val context: Context) : IRealmDatabase {


    var realm2: BizumDataBaseRealm = BizumDataBaseRealm(context)



     fun insertCardSetupListObjects() {
        realm2.addObjectFromRealm { cardlistSetup().map { it.toRCardSetupEntity() } }


    }
    fun insertCardListHomeObjects (){
        realm2.addObjectFromRealm{ cardlisthome().map { it.toRCardHomeTaskEntity() } }
    }

    fun insertCardListCarrousel (){
        realm2.addObjectFromRealm{ cardListCarrousel().map { it.toRCardCarrouselEntity() } }
    }

    fun getCardListSetupObjects() : List<CardSetup> {
        insertCardSetupListObjects()
        return realm2.getObjectsFromRealm { where<RCardSetupEntity>().findAll() }.map { it.toCardSetup() }
    }

    fun getCardListHomeObjects() : List<CardHomeTask> {
        realm2.deleteAllData()
        insertCardListHomeObjects()
        return realm2.getObjectsFromRealm { where<RCardHomeTaskEntity>().findAll() }.map { it.toCardHomeTask() }
    }

    fun getCardListCarrouselObjects() : List<CardCarrousel> {
        insertCardListCarrousel()
        return realm2.getObjectsFromRealm { where<RCardCarrouselEntity>().findAll() }.map { it.toCardCarrousel() }
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

    override fun <O : RealmResults<I>, I : RealmModel> getObjectsFromRealm(action: Realm.() -> O): List<I> {
        TODO("Not yet implemented")
    }

    override fun <T : RealmModel> addObjectFromRealm(action: () -> List<T>) {
        insertCardListHomeObjects()
    }

    override fun <T : RealmObject> deleteObjectFromRealm(action: Realm.() -> T, id: Long) {
        TODO("Not yet implemented")
    }
}