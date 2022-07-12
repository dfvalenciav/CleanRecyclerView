package com.example.daval.cleanrecyclerview.organizationList.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [OrgEntity::class],
    version = 1
        )

abstract class OrgDataBase : RoomDatabase() {
    abstract val dao : OrgDao
}