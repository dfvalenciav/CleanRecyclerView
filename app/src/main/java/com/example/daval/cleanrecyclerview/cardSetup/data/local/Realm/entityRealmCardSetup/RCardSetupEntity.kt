package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardSetup

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class RCardSetupEntity(
    var type: String = "",
    var number: String = "",
    var preferred: Boolean = false,
    var amount:Int = 0,
    var clientName: String = "",
    var clientId: Int = 0,
    @PrimaryKey
    var id: Long = 0,) : RealmObject()