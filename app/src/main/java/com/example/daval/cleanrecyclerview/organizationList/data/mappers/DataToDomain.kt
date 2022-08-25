package com.example.daval.cleanrecyclerview.organizationList.data.mappers

import com.example.daval.cleanrecyclerview.organizationList.data.local.entity.OrgRealm
import com.example.daval.cleanrecyclerview.organizationList.domain.models.Org


/***
 * Map object instance of  type domain.Org with data of object Data.OrgEntity
 */
fun OrgRealm.toOrg() = Org(name, code, phone, nit, city, employees )

fun List<OrgRealm>.toListOrg() = map { data ->
    data.toOrg()
}
