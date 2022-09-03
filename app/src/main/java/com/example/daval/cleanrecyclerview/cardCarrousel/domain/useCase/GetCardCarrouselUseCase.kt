package com.example.daval.cleanrecyclerview.cardCarrousel.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardCarrousel.domain.interfaces.IRealmRepositoryCards
import com.example.daval.cleanrecyclerview.cardCarrousel.domain.models.CardCarrousel
import javax.inject.Inject

class GetCardCarrouselUseCase @Inject constructor(
    private val repository: IRealmRepositoryCards
) : BaseUseCase<CardCarrousel>(){

    override suspend fun execute(): List<CardCarrousel> {
        return repository.getCardListCarrouselObjects()
    }
}