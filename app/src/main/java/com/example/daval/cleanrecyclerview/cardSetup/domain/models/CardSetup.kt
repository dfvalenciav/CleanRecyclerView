package com.example.daval.cleanrecyclerview.cardSetup.domain.models

data class CardSetup (
    val type: String,
    val number: String,
    val preferred: Boolean,
    val amount:Int,
    val clientName: String,
    val clientId: Int,
        )