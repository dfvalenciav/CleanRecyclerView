package com.example.daval.cleanrecyclerview.cardSetup.domain.models

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.TypeConfigEnum

data class Config(
    val type : TypeConfigEnum? = null,
    val title: String,
    val message: String,
    val image: Int,
    val backGround: Int,
    val indicatorSwitch: Boolean
)