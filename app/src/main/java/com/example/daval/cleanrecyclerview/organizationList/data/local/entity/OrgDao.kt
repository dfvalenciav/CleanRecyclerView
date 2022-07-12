package com.example.daval.cleanrecyclerview.organizationList.data.local.entity

import androidx.room.*


@Dao
interface OrgDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrg(organizations : List<OrgEntity>)

    @Query ("DELETE FROM OrgEntity")
    suspend fun delete()

    @Query ("SELECT * FROM OrgEntity")
    suspend fun getOrgList(): List<OrgEntity>
}