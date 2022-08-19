package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardHome


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCardHomeTaskEntity(
    var task : String = "",
    var description: String = "",
    var icon: String = "",
    @PrimaryKey
    var id: Long = 0,) : RealmObject()