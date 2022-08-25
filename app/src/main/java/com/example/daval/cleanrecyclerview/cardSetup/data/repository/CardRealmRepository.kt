package com.example.daval.cleanrecyclerview.cardSetup.data.repository

import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.IRealmDatabase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.MockDataBase
import com.example.daval.cleanrecyclerview.cardSetup.data.local.realm.*
import com.example.daval.cleanrecyclerview.cardSetup.data.mappers.*
import com.example.daval.cleanrecyclerview.cardSetup.domain.interfaces.ICardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import io.realm.kotlin.where
import javax.inject.Inject


class CardRealmRepository @Inject constructor(private val realmDataBase: IRealmDatabase)
    : ICardRealmRepository {

    private val mockDataBase by lazy { MockDataBase() }


    override suspend fun getCardListSetupObjects() : List<CardSetup> {
        insertCardSetupListObjects(mockDataBase.cardlistSetup())
        return realmDataBase.getObjectsFromRealm { where<RCardSetup>().findAll() }.toRListCardSetup()
    }

    override suspend fun insertCardSetupListObjects(cardSetup: List<CardSetup>) {
        realmDataBase.deleteAllObjectFromRealm { RCardSetup() }
        return realmDataBase.addObjectFromRealm { cardSetup.toRListCardSetup() }
    }

    override suspend fun getCardListHomeObjects() : List<CardHomeTask> {
        insertCardListHomeObjects(mockDataBase.cardlisthome())
        return realmDataBase.getObjectsFromRealm { where<RCardHomeTask>().findAll() }.toRListCardHomeTask()
    }

    override suspend fun insertCardListHomeObjects(cardHomeTask: List<CardHomeTask>){
        realmDataBase.deleteAllObjectFromRealm { RCardHomeTask() }
        return realmDataBase.addObjectFromRealm{ cardHomeTask.toRListCardHomeTask()}
    }

    override suspend fun getCardListCarrouselObjects() : List<CardCarrousel> {
        insertCardListCarrousel(mockDataBase.cardListCarrousel())
        return realmDataBase.getObjectsFromRealm { where<RCardCarrousel>().findAll() }.toRListCardCarrouselTask()
    }

    override suspend fun insertCardListCarrousel(cardCarrousel: List<CardCarrousel>){
        realmDataBase.deleteAllObjectFromRealm { RCardCarrousel() }
        return realmDataBase.addObjectFromRealm{ cardCarrousel.sortedBy { it.BankName }.toRListCardCarrouselEntity()}
    }

    override suspend fun getListConfig(): List<Config> {
        insertConfig(mockDataBase.config())
        return realmDataBase.getObjectsFromRealm { where<RConfig>().findAll() }.toListConfig()
    }

    override suspend fun insertConfig(config: List<Config>) {
        realmDataBase.deleteAllObjectFromRealm { RConfig() }
        return realmDataBase.addObjectFromRealm { config.toListConfigRealm() }
    }
}