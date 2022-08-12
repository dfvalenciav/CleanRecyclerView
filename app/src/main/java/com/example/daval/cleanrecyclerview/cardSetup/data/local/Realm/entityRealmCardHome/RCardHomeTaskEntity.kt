package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm.entityRealmCardHome


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCardHomeTaskEntity(Taks: String, Description: String, Icon: String) : RealmObject() {
    @PrimaryKey
    var id: Int? = null
    var Task : String = ""
    var Description: String = ""
    var Icon: String = ""
}