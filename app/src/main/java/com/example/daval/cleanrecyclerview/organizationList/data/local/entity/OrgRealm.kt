package com.example.daval.cleanrecyclerview.organizationList.data.local.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class OrgRealm(
    var name: String = "",
    var code: String = "",
    var phone: String = "",
    var nit: Int = 0,
    var city: String = "",
    var employees: Int = 0,
    @PrimaryKey var id: Long? = 0
) : RealmObject()