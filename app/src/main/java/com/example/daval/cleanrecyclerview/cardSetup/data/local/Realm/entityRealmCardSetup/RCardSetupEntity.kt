package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardSetup

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class RCardSetupEntity(    @PrimaryKey
                                var id: Int = 0,
                                var type: String = "",
                                var number: String = "",
                                var preferred: Boolean = false,
                                var amount:Int = 0,
                                var clientName: String = "",
                                var clientId: Int = 0) : RealmObject() {

}