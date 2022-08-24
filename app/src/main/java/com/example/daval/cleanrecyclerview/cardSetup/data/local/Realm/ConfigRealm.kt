package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ConfigRealm(

    var title: String = "",
    var message: String = "",
    var image: Int = 0,
    var backGround: Int = 0,
    var indicatorSwitch: Boolean= false,
    @PrimaryKey var id: Long? = 0

) : RealmObject()