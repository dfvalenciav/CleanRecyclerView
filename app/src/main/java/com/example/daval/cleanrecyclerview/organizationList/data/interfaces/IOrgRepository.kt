package com.example.daval.cleanrecyclerview.organizationList.data.interfaces

import com.example.daval.cleanrecyclerview.organizationList.domain.models.Org

interface IOrgRepository {

    suspend fun getOrgList (): List<Org>

    suspend fun insertOrganization (organization : List<Org>)
}