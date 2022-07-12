package com.example.daval.cleanrecyclerview.organizationList.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class OrgEntity (
    val name: String,
    val code: String,
    val phone: String,
    val nit:Int,
    val city: String,
    val employees: Int,
    @PrimaryKey val id: Int? = null,
    )