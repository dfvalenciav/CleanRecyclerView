package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardSetupRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup

class GetCardSetupUseCase (private val repository: CardSetupRepository) : BaseUseCase<CardSetup> (){
    override suspend fun execute(): List<CardSetup> {
        return repository.getCardList()
    }
}



