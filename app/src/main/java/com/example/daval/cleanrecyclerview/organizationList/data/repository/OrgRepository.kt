package com.example.daval.cleanrecyclerview.organizationList.data.repository

import com.example.daval.cleanrecyclerview.organizationList.data.interfaces.IOrgRepository
import com.example.daval.cleanrecyclerview.organizationList.data.local.entity.OrgDao
import com.example.daval.cleanrecyclerview.organizationList.data.mappers.toOrg
import com.example.daval.cleanrecyclerview.organizationList.data.mappers.toOrgEntity
import com.example.daval.cleanrecyclerview.organizationList.domain.models.Org

class OrgRepository (private val orgDao: OrgDao) : IOrgRepository {

    override suspend fun getOrgList(): List<Org> {
        orgDao.delete()
        insertOrganization(organizations())
        return orgDao.getOrgList().map { it.toOrg() }
    }

    override suspend fun insertOrganization(organization: List<Org>) {
        orgDao.insertOrg((organization.map{it.toOrgEntity()}))
    }

    private fun organizations(): List<Org> = listOf(
        Org("BBVA", "111111", "+000-000-0000", 1234, "Valencia", 100000),
        Org("Santander", "222222", "+123-000-0000", 1025, "Madrid", 200000),
        Org("Sanitas", "333333", "+564-000-0000", 4422, "Barcelona", 15000),
        Org("IKEA", "444444", "+468-000-0000", 4321, "Valencia", 100000),
        Org("Zara", "555555", "+685-000-0000", 1025, "Cadiz", 150000),
        Org("Telefonica", "666666", "+732-000-0000", 145, "Ibiza", 15000),
        Org("CaixaBank", "777777", "+558-000-0000", 6655, "Valencia", 100000),
        Org("Iberdrola", "888888", "+654-000-0000", 5874, "Sevilla", 200000),
        Org("Sanitas", "333333", "+564-000-0000", 4422, "Barcelona", 15000),
    )
}