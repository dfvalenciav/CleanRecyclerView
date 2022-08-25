package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.interfaces.ICardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import javax.inject.Inject

class GetCardHomeTaksUseCase @Inject constructor(
    private val repository: ICardRealmRepository
) : BaseUseCase<CardHomeTask>() {

    override suspend fun execute(): List<CardHomeTask> {
        return repository.getCardListHomeObjects()
    }
}
