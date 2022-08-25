package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.interfaces.ICardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardCarrousel
import javax.inject.Inject

class GetCardCarrouselUseCase @Inject constructor(
    private val repository: ICardRealmRepository
) : BaseUseCase<CardCarrousel>(){

    override suspend fun execute(): List<CardCarrousel> {
        return repository.getCardListCarrouselObjects()
    }
}