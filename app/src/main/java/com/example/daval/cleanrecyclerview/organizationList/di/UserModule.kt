package com.example.daval.cleanrecyclerview.organizationList.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.IRealmDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.CardSetupDataBase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardCarrouselUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardHomeTaksUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetCardSetupUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.SetCardSetupUseCase
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

/*    @Provides
    @Singleton
    fun provideGetCardSetupUseCase(repository: CardRepository): GetCardSetupUseCase {
        return GetCardSetupUseCase(repository)
    }*/

    @Provides
    @Singleton
    fun provideGetCardSetupUseCase(repository: CardRealmRepository): GetCardSetupUseCase {
        return GetCardSetupUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSetCardSetupUseCase(): SetCardSetupUseCase {
        return SetCardSetupUseCase()
    }

/*    @Provides
    @Singleton
    fun provideGetCardHomeTaskUseCase(repository: CardRepository): GetCardHomeTaksUseCase {
        return GetCardHomeTaksUseCase(repository)
    }*/

    @Provides
    @Singleton
    fun provideGetCardHomeTaskUseCase(repository: CardRealmRepository): GetCardHomeTaksUseCase {
        return GetCardHomeTaksUseCase(repository)
    }

   @Provides
    @Singleton
    fun provideGetCardCarrouselUseCase(repository: CardRepository): GetCardCarrouselUseCase {
        return GetCardCarrouselUseCase(repository)
    }

/*    @Provides
    @Singleton
    fun provideGetCardCarrouselUseCase(repository: CardRealmRepository): GetCardCarrouselUseCase {
        return GetCardCarrouselUseCase(repository)
    }*/

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
    ) : CardRepository {
        return  CardRepository(db.dao)
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