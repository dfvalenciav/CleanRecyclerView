package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import android.util.Log
import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.interfaces.ICardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.ICardListPreferred
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import javax.inject.Inject


class SetCardSetupUseCase @Inject constructor(
    private val repository: ICardRealmRepository
): BaseUseCase<CardSetup>() {
    override suspend fun execute(): List<CardSetup> {
        return repository.getCardListSetupObjects()
    }
}