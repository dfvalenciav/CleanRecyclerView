package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

data class cardListPresentation(
    var cardListType : String ?,
    var cardListNumber: String?,
    var cardListPrefered: Boolean ?
)

fun equals (oldItem : cardListPresentation, newItem: cardListPresentation) : Boolean =
    oldItem.cardListType == newItem.cardListType && oldItem.cardListPrefered == newItem.cardListPrefered &&
            oldItem.cardListPrefered == newItem.cardListPrefered