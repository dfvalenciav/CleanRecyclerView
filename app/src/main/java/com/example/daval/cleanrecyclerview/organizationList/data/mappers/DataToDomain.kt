package com.example.daval.cleanrecyclerview.organizationList.data.mappers

import com.example.daval.cleanrecyclerview.organizationList.data.local.entity.OrgEntity
import com.example.daval.cleanrecyclerview.organizationList.domain.models.Org


/***
 * Map object instance of  type domain.Org with data of object Data.OrgEntity
 */
fun OrgEntity.toOrg() = Org(name, code, phone, nit, city, employees )

fun List<OrgEntity>.toListOrg() = map { data ->
    data.toOrg()
}
