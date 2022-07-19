package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CardSetupPresentation(
    var cardListType : String ?,
    var cardListNumber: String?,
    var cardListPrefered: Boolean ?
):Parcelable

fun equals (oldItem : CardSetupPresentation, newItem: CardSetupPresentation) : Boolean =
    oldItem.cardListType == newItem.cardListType && oldItem.cardListPrefered == newItem.cardListPrefered &&
            oldItem.cardListPrefered == newItem.cardListPrefered