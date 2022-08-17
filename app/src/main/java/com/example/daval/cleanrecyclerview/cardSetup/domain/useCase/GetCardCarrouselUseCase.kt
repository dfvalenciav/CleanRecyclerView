package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardCarrousel

class GetCardCarrouselUseCase (private val repository: CardRepository) : BaseUseCase<CardCarrousel>(){
    override suspend fun execute(): List<CardCarrousel> {
        return repository.getCardListCarrousel()
    }
}