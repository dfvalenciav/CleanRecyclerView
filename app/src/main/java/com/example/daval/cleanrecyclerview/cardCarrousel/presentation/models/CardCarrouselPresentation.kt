package com.example.daval.cleanrecyclerview.cardCarrousel.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CardCarrouselPresentation(
    var BankLogo : Int,
    var BankName: String,
    var CardNumber: String,
    var CardExpiration: String,
    var CardFranchise: Int,
    var CardBackground: Int,
): Parcelable

fun equals (oldItem : CardCarrouselPresentation, newItem: CardCarrouselPresentation) : Boolean =
    oldItem.BankName == newItem.BankName && oldItem.BankLogo == newItem.BankLogo && oldItem.CardNumber == newItem.CardNumber
            && oldItem.CardExpiration == newItem.CardExpiration  && oldItem.CardFranchise == newItem.CardFranchise
