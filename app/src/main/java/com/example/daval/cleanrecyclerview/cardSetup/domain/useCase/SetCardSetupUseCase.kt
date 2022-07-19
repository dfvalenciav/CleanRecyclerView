package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import android.util.Log
import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter.ICardListPreferred
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation


class SetCardSetupUseCase: BaseUseCase<CardSetup>(), ICardListPreferred {
    val datapassed : CardSetupPresentation = CardSetupPresentation("Tarjeta de crédito", "1234567890", true)
    val selectedCard : List<CardSetup> = mutableListOf(
        CardSetup("Tarjeta de crèdito", "1234567890",false,10000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de dèbito", "3855695039",false,20000,"Pedro Pèrez", 321567765))
    override suspend fun execute(): List<CardSetup> {
        addPreferredCard(datapassed)
        return selectedCard
    }

    override fun addPreferredCard(datapassed: CardSetupPresentation)   {
        Log.d("PRUEBA", selectedCard.size.toString())
        val preferredCard = CardSetup(datapassed.cardListType?:"", datapassed.cardListNumber?:"", datapassed.cardListPrefered?:true, 1, "Pedro Pérez", 321567765)
        selectedCard.plusElement(preferredCard)
    }
}