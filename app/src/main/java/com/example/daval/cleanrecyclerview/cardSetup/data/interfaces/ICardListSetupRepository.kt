package com.example.daval.cleanrecyclerview.cardSetup.data.interfaces

import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*

interface ICardListSetupRepository {

    suspend fun getCardList () : List<CardSetup>

    suspend fun insertCardSetup (cardSetup : List<CardSetup>)

    fun updateCard (card : CardSetup) :Boolean

    suspend fun getCardListHomeTask () : List<CardHomeTask>

    suspend fun insertCardHomeTask (cardHomeTask : List<CardHomeTask>)

    suspend fun getCardListCarrousel () : List<CardCarrousel>

    suspend fun insertCardCarrousel(cardCarrousel: List<CardCarrousel>)


    ///DIALOG INTERFACE

    //User
    suspend fun getListUser(): List<User>

    suspend fun insertUsers(users: List<User>)

    suspend fun updateUser(user: User)


    //UserDetail
    suspend fun getListUserDetail(): List<UserDetail>

    suspend fun insertUserDetail(userDetail: List<UserDetail>)

    suspend fun updateUserDetail(userDetail: UserDetail)
}