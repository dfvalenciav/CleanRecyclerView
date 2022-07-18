package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup



class SetCardSetupUseCase: BaseUseCase<CardSetup>() {
    val selectedCard : List<CardSetup> = listOf(
        CardSetup("Tarjeta de crèdito", "1234567890",false,10000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de dèbito", "3855695039",false,20000,"Pedro Pèrez", 321567765))
    override suspend fun execute(): List<CardSetup> {
        return selectedCard
    }
}