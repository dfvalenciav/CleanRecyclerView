package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected.Adapter

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation

interface ICardSelectListener {
    fun onClickCardSelect (datapassed : CardSetupPresentation)
}