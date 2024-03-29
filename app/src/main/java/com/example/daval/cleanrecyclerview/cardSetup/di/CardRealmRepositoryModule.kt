package com.example.daval.cleanrecyclerview.cardSetup.di


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.interfaces.ICardRealmRepository


@Module
@InstallIn(ViewModelComponent::class)
interface CardRealmRepositoryModule {
    @Binds
    fun bind(repository: CardRealmRepository): ICardRealmRepository
}