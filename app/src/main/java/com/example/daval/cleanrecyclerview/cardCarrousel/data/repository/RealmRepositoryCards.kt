package com.example.daval.cleanrecyclerview.cardCarrousel.data.repository

import com.example.daval.cleanrecyclerview.cardCarrousel.data.interfaces.IRealmDatabaseCards
import com.example.daval.cleanrecyclerview.cardCarrousel.data.local.MockDataBaseCards
import com.example.daval.cleanrecyclerview.cardCarrousel.data.mappers.toRListCardCarrouselEntity
import com.example.daval.cleanrecyclerview.cardCarrousel.data.mappers.toRListCardCarrouselTask
import com.example.daval.cleanrecyclerview.cardCarrousel.data.models.RCardCarrousel
import com.example.daval.cleanrecyclerview.cardCarrousel.domain.interfaces.IRealmRepositoryCards
import com.example.daval.cleanrecyclerview.cardCarrousel.domain.models.CardCarrousel
import io.realm.kotlin.where
import javax.inject.Inject

class RealmRepositoryCards @Inject constructor(private val realmDataBase: IRealmDatabaseCards)
    : IRealmRepositoryCards {

    private val mockDataBaseCards by lazy { MockDataBaseCards() }

    override suspend fun getCardListCarrouselObjects() : List<CardCarrousel> {
        insertCardListCarrousel(mockDataBaseCards.cardListCarrousel())
        return realmDataBase.getObjectsFromRealm { where<RCardCarrousel>().findAll() }.toRListCardCarrouselTask()
    }

    override suspend fun insertCardListCarrousel(cardCarrousel: List<CardCarrousel>){
        //realmDataBase.deleteAllObjectFromRealm { RCardCarrousel() }
        return realmDataBase.addObjectFromRealm{ cardCarrousel.sortedBy { it.BankName }.toRListCardCarrouselEntity()}
    }
}