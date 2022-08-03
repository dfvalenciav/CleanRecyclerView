package com.example.daval.cleanrecyclerview.cardSetup.data.interfaces

import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup

interface ICardListSetupRepository {

    suspend fun getCardList () : List<CardSetup>

    suspend fun insertCardSetup (cardSetup : List<CardSetup>)

    fun updateCard (card : CardSetup) :Boolean

    suspend fun getCardListHomeTask () : List<CardHomeTask>

    suspend fun insertCardHomeTask (cardHomeTask : List<CardHomeTask>)

    suspend fun getCardListCarrousel () : List<CardCarrousel>

    suspend fun insertCardCarrousel(cardCarrousel: List<CardCarrousel>)
}