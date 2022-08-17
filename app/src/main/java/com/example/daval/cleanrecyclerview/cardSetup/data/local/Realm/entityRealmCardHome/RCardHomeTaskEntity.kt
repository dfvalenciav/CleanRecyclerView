package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardHome


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCardHomeTaskEntity(
    var Task : String = "",
    var Description: String = "",
    var Icon: String = "",
    @PrimaryKey
    var id: Long = 0,) : RealmObject()