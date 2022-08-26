package com.example.daval.cleanrecyclerview.cardSetup.domain.models

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.StateEnum

data class Config(
    val position : StateEnum? = null,
    val title: String,
    val message: String,
    val image: Int,
    val backGround: Int,
    val indicatorSwitch: Boolean
)