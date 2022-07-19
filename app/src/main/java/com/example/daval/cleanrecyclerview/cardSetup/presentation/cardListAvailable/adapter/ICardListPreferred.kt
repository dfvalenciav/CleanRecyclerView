package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter

import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation

interface ICardListPreferred  {
    fun addPreferredCard (datapassed: CardSetupPresentation)
}