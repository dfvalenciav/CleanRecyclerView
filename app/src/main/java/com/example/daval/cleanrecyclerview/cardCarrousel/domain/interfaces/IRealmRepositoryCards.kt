package com.example.daval.cleanrecyclerview.cardCarrousel.domain.interfaces

import com.example.daval.cleanrecyclerview.cardCarrousel.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Config
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Org

interface IRealmRepositoryCards {

    suspend fun getCardListCarrouselObjects(): List<CardCarrousel>
    suspend fun insertCardListCarrousel(cardCarrousel: List<CardCarrousel>)
}