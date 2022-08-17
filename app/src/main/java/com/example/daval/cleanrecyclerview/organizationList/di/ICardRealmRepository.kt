package com.example.daval.cleanrecyclerview.organizationList.di

import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.IRealmDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.BizumDataBaseRealm
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRealmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ICardRealmRepository {
    @Binds
    fun bind(repository: CardRealmRepository) : IRealmDatabase
}