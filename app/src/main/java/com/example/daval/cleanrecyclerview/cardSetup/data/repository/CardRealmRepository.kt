package com.example.daval.cleanrecyclerview.cardSetup.data.repository

import android.content.Context
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.IRealmDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.BizumDataBaseRealm
import com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.*
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.*
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.StateEnum
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
        realm2.addObjectFromRealm{ cardListCarrousel().sortedBy { it.BankName }.map { it.toRCardCarrouselEntity() } }
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

    fun getListUser(): List<User> {
        insertUsers(users())
        return  realm2.getObjectsFromRealm { where<UserRealm>().findAll()  }.toListUser()
    }

    fun insertUsers(users: List<User>) {
        realm2.deleteAllObjectFromRealm { UserRealm() }
        return realm2.addObjectFromRealm { users.toListUser() }
    }

   fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    fun getListUserDetail(): List<UserDetail> {
        insertUserDetail(userDetail())
        return realm2.getObjectsFromRealm { where<UserDetailRealm>().findAll() }.toListUserDetail()
    }

    fun insertUserDetail(userDetail: List<UserDetail>) {
        realm2.deleteAllObjectFromRealm { UserDetailRealm() }
        return realm2.addObjectFromRealm { userDetail.toListUserDetailRealm() }
    }

    fun updateUserDetail(userDetail: UserDetail) {
        TODO("Not yet implemented")
    }

    fun getListConfig(): List<Config> {
        insertConfig(config())
        return realm2.getObjectsFromRealm { where<ConfigRealm>().findAll() }.toListConfig()
    }

    fun insertConfig(config: List<Config>) {
        realm2.deleteAllObjectFromRealm { ConfigRealm() }
        return realm2.addObjectFromRealm { config.toListConfigRealm() }
    }

    fun updateConfig(config: Config) {
        TODO("Not yet implemented")
    }


    private fun config():List<Config> = listOf(
        Config("Touch ID","Utiliza tu huella para acceder a la App de una forma rápida y segura.", R.drawable.ic_fingerprint,R.drawable.bg_light_orange,false),
        Config("Pago móvil","Realiza tus compras con el móvil sin necesidad de usar tu tarjeta.", R.drawable.ic_pay_mobile,R.drawable.bg_light_purple,false)
    )


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

    private fun userDetail(): List<UserDetail> = listOf(
        UserDetail("Antonia", StateEnum.CHECK,null),
        UserDetail("Marina",StateEnum.CHECK,null),
        UserDetail("Miriam",StateEnum.CHECK,null),
        UserDetail("Adriana",StateEnum.FAILURE,null),
        UserDetail("Liliana",StateEnum.FAILURE,null),
        UserDetail("Sandra",StateEnum.TIME,StateEnum.GARBAGE),
        UserDetail("Teresa",StateEnum.TIME,StateEnum.GARBAGE),
        UserDetail("Manuela",StateEnum.TIME,StateEnum.GARBAGE)
    )


    private fun users(): List<User> = listOf(
        User("Silvia", "", "123456789","https://randomuser.me/api/portraits/women/50.jpg",  "0000001",1),
        User("Ana", "", "123456789","https://randomuser.me/api/portraits/women/60.jpg",  "0000011",2),
        User("Antonia", "", "123456789","https://randomuser.me/api/portraits/women/70.jpg", "0000111",3),
        User("Jennifer", "", "123456789","https://randomuser.me/api/portraits/women/80.jpg",  "0001111",4),
        User("Alexandra", "", "123456789","https://randomuser.me/api/portraits/women/90.jpg", "0011111",5),
        User("Manuela", "", "123456789","https://randomuser.me/api/portraits/women/20.jpg",  "0111111",6),
        User("Teresa", "", "123456789","https://randomuser.me/api/portraits/women/49.jpg",  "0000001",7),
        User("Sandra", "", "123456789","https://randomuser.me/api/portraits/women/48.jpg",  "0000011",8),
        User("Adriana", "", "123456789","https://randomuser.me/api/portraits/women/47.jpg", "0000111",9),
        User("Liliana", "", "123456789","https://randomuser.me/api/portraits/women/46.jpg",  "0001111",10),
        User("Miriam", "", "123456789","https://randomuser.me/api/portraits/women/45.jpg", "0011111",11),
        User("Marina", "", "123456789","https://randomuser.me/api/portraits/women/44.jpg",  "0111111",12)
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

    override fun <T : RealmModel> deleteAllObjectFromRealm(action: () -> T) {
        TODO("Not yet implemented")
    }
}