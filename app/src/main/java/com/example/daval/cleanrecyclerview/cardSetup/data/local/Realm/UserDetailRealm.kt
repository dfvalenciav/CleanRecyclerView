package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserDetailRealm(
    var name: String = "",
    var userGarbageIcon: String = "",
    var userSmallIcon: String = "",
    @PrimaryKey var id: Long? = 0

):RealmObject()