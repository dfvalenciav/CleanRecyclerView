package com.example.daval.cleanrecyclerview.cardSetup.data.local.realm


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RCardHomeTask(
    var task : String = "",
    var description: String = "",
    var icon: String = "",
    @PrimaryKey var id: Long = 0
) : RealmObject()