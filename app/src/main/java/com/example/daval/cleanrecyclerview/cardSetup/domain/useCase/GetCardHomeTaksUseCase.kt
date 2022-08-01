package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask

class GetCardHomeTaksUseCase (private val repository: CardRepository) : BaseUseCase<CardHomeTask> (){
    override suspend fun execute(): List<CardHomeTask> {
        return repository.getCardListHomeTask()
    }
}
