package com.example.daval.cleanrecyclerview.organizationList.data.mappers

import com.example.daval.cleanrecyclerview.organizationList.data.local.entity.OrgRealm
import com.example.daval.cleanrecyclerview.organizationList.domain.models.Org

/**
 * Map object instance of  type Data.OrgEntity with data of object domain.Org
 */
fun Org.toOrgRealm() = OrgRealm ( name, code, phone, nit, city, empleados)

fun List<Org>.toListOrgRealm() = map { domain ->
    domain.toOrgRealm()
}