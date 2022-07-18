package com.example.daval.cleanrecyclerview.cardSetup.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardSetup (
    val type: String,
    val number: String,
    val preferred: Boolean,
    val amount:Int,
    val clientName: String,
    val clientId: Int,
        ) : Parcelable
