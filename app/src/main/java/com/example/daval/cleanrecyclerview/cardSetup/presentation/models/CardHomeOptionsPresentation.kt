package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardHomeOptionsPresentation(
    var cardHomeTitle : String ?,
    var cardHomeDescription: String?,
    var cardHomeIcon: String?
): Parcelable

fun equals (oldItem : CardHomeOptionsPresentation, newItem: CardHomeOptionsPresentation) : Boolean =
    oldItem.cardHomeTitle == newItem.cardHomeTitle && oldItem.cardHomeDescription == newItem.cardHomeDescription &&
            oldItem.cardHomeIcon == newItem.cardHomeIcon