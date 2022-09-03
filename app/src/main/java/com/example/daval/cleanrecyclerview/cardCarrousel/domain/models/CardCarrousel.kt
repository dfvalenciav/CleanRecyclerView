package com.example.daval.cleanrecyclerview.cardCarrousel.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardCarrousel(
    val BankLogo : Int,
    val BankName: String,
    val CardNumber: String,
    val CardExpiration: String,
    val CardFranchise: Int,
    val CardBackground: Int,
) : Parcelable
