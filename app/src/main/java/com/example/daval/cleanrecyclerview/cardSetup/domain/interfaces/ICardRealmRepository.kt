package com.example.daval.cleanrecyclerview.cardSetup.domain.interfaces

import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Config
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Org

interface ICardRealmRepository {

    suspend fun getCardListSetupObjects():List<CardSetup>
    suspend fun insertCardSetupListObjects(cardSetup: List<CardSetup>)


    suspend fun getCardListHomeObjects(): List<CardHomeTask>
    suspend fun insertCardListHomeObjects(cardHomeTask: List<CardHomeTask>)


    suspend fun getCardListCarrouselObjects(): List<CardCarrousel>
    suspend fun insertCardListCarrousel(cardCarrousel: List<CardCarrousel>)


    suspend fun getListConfig(): List<Config>
    suspend fun insertConfig(config: List<Config>)


    suspend fun getOrgList (): List<Org>
    suspend fun insertOrganization (organization : List<Org>)

}