package com.example.daval.cleanrecyclerview.organizationList.di

import android.app.Application
import androidx.room.Room
import com.example.daval.cleanrecyclerview.cardSetup.data.local.entity.CardSetupDataBase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardSetupRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardSetupUseCase
import com.example.daval.cleanrecyclerview.organizationList.data.local.entity.OrgDataBase
import com.example.daval.cleanrecyclerview.organizationList.data.repository.OrgRepository
import com.example.daval.cleanrecyclerview.organizationList.domain.useCase.GetOrgUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn (SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun provideGetOrgUseCase(repository: OrgRepository): GetOrgUseCase {
        return GetOrgUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCardSetupUseCase(repository: CardSetupRepository): GetCardSetupUseCase {
        return GetCardSetupUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUserRepository (
        db : OrgDataBase
    ) : OrgRepository {
        return  OrgRepository(db.dao)
    }

    @Provides
    @Singleton
    fun provideCardSetupRepository (
        db : CardSetupDataBase
    ) : CardSetupRepository {
        return  CardSetupRepository(db.dao)
    }

    @Provides
    @Singleton
    fun provideOrgDataBase (app: Application) : OrgDataBase {
        return Room.databaseBuilder(
            app, OrgDataBase::class.java,"org_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCardSetupDataBase (app: Application) : CardSetupDataBase {
        return Room.databaseBuilder(
            app, CardSetupDataBase::class.java,"cardSetup_db"
        ).build()
    }
}