package com.example.daval.cleanrecyclerview.cardSetup.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardHomeTask (
    val Taks: String,
    val Description: String,
    val Icon: String
        ) : Parcelable