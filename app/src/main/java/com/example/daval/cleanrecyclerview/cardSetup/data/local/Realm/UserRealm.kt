package com.example.daval.cleanrecyclerview.cardSetup.data.local.Realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class UserRealm(
    var name: String="",
    var lastName: String="",
    var numPhone: String="",
    var userImage: String="",
    var numAccount: String="",
    var age: Int=0,
    @PrimaryKey var id: Long? = 0

) : RealmObject()