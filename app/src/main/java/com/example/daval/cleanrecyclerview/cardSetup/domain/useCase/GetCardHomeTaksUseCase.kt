package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.data.interfaces.ICardListSetupRepository
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardSetupRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask

class GetCardHomeTaksUseCase (private val repository: CardSetupRepository) : BaseUseCase<CardHomeTask> (){
    override suspend fun execute(): List<CardHomeTask> {
        return repository.getCardListHomeTask()
    }

}
