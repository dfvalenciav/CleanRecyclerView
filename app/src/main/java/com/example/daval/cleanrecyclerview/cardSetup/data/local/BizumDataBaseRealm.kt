package com.example.daval.cleanrecyclerview.cardSetup.data.local

import android.content.Context
import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.IRealmDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import io.realm.*
import io.realm.kotlin.deleteFromRealm
import javax.inject.Inject

class BizumDataBaseRealm @Inject constructor(@ApplicationContext private val context: Context) :
    IRealmDatabase {

    private val realmConfiguration by lazy { realmConfiguration(context) }
    private fun getRealm(): Realm {
        return try {
            Realm.getInstance(realmConfiguration)
        } catch (e: IllegalArgumentException) {
            deleteAllData()
            Realm.getInstance(realmConfiguration)
        }
    }
     fun deleteAllData() {
        val realm = getRealm()
        realm.beginTransaction()
        realm.deleteAll()
        realm.commitTransaction()
        realm.close()
    }
    override fun <O : RealmResults<I>, I : RealmModel> getObjectsFromRealm(action: Realm.() -> O): List<I> {
        val realm = getRealm()
        val results = action(realm)
        val list = results.map { realm.copyFromRealm(it) }
        realm.close()
        return list
    }


    override fun <T : RealmModel> addObjectFromRealm(action: () -> List<T>) {
        val realmModel = action()
        val realm = getRealm()
        realm.beginTransaction()
        realm.insertOrUpdate(realmModel)
        realm.commitTransaction()
        realm.close()
    }

    override fun <T : RealmObject> deleteObjectFromRealm(action: Realm.() -> T, id: Long) {
        val realm = getRealm()
        val realmModel = action(realm)
        realm.beginTransaction()
        try {
            if (realmModel.isValid) {
                val obj = realm.where(realmModel.javaClass).equalTo("id", id).findFirst()
                if(obj != null) {
                    obj.deleteFromRealm()
                    realm.commitTransaction()
                    realm.close()
                } else realm.cancelTransaction()
            } else realm.cancelTransaction()
        } catch (e: Exception) {
            realm.cancelTransaction()
        }
    }
}


fun realmConfiguration(@ApplicationContext context: Context): RealmConfiguration {
    Realm.init(context)
    return RealmConfiguration.Builder()
        .deleteRealmIfMigrationNeeded()
        .build()
}