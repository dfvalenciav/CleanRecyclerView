package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask

class GetCardHomeTaksUseCase (private val repository: CardRealmRepository) : BaseUseCase<CardHomeTask> (){
    override suspend fun execute(): List<CardHomeTask> {
        return repository.getCardListHomeObjects()
    }
}
