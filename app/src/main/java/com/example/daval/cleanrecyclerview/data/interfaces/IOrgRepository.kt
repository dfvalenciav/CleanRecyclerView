package com.example.daval.cleanrecyclerview.data.interfaces

import com.example.daval.cleanrecyclerview.domain.models.Org

interface IOrgRepository {

    suspend fun getOrgList (): List<Org>

    suspend fun insertOrganization (organization : List<Org>)
}