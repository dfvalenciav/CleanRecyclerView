package com.example.daval.cleanrecyclerview.cardSetup.data.local.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class ROrg(
    var name: String = "",
    var code: String = "",
    var phone: String = "",
    var nit: Int = 0,
    var city: String = "",
    var employees: Int = 0,
    @PrimaryKey var id: Long? = 0
) : RealmObject()