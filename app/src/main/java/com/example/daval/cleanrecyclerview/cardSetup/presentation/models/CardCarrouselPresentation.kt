package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CardCarrouselPresentation(
    var BankLogo : String,
    var BankName: String,
    var CardNumber: String,
    var CardExpiration: String,
    var CardFranchise: String,
    var CardBackground: String,
): Parcelable

fun equals (oldItem : CardCarrouselPresentation, newItem: CardCarrouselPresentation) : Boolean =
    oldItem.BankName == newItem.BankName && oldItem.BankLogo == newItem.BankLogo && oldItem.CardNumber == newItem.CardNumber
            && oldItem.CardExpiration == newItem.CardExpiration  && oldItem.CardFranchise == newItem.CardFranchise
