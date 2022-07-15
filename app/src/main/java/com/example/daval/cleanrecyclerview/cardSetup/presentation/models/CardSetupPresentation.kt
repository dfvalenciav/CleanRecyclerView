package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

data class CardSetupPresentation(
    var cardListType : String ?,
    var cardListNumber: String?,
    var cardListPrefered: Boolean ?
)

fun equals (oldItem : CardSetupPresentation, newItem: CardSetupPresentation) : Boolean =
    oldItem.cardListType == newItem.cardListType && oldItem.cardListPrefered == newItem.cardListPrefered &&
            oldItem.cardListPrefered == newItem.cardListPrefered