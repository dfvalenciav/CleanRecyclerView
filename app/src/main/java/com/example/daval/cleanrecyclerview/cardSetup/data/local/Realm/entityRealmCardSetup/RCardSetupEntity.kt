package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardSetup

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class RCardSetupEntity(
    type: String,
    number: String,
    preferred: Boolean,
    amount: Int,
    clientName: String,
    clientId: Int,
    @PrimaryKey
    var id: Int? = null
) : RealmObject() {
    val type: String = ""
    val number: String = ""
    val preferred: Boolean = false
    val amount:Int = 0
    val clientName: String = ""
    val clientId: Int = 0
}