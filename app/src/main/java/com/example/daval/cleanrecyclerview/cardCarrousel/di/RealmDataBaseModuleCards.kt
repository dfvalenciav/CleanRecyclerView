package com.example.daval.cleanrecyclerview.cardCarrousel.di


import com.example.daval.cleanrecyclerview.cardCarrousel.data.interfaces.IRealmDatabaseCards
import com.example.daval.cleanrecyclerview.cardCarrousel.data.local.RealmDataBaseCards
import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.IRealmDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.RealmDataBase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
interface RealmDataBaseModuleCards {
    @Binds
    fun bind(repository: RealmDataBaseCards): IRealmDatabaseCards
}