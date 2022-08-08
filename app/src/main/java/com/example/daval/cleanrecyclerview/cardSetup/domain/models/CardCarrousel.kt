package com.example.daval.cleanrecyclerview.cardSetup.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardCarrousel(
    val BankLogo : String,
    val BankName: String,
    val CardNumber: String,
    val CardExpiration: String,
    val CardFranchise: String,
    val CardBackground: String,
) : Parcelable
