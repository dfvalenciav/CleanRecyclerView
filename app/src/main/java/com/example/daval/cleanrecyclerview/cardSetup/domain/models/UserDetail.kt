package com.example.daval.cleanrecyclerview.cardSetup.domain.models

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.StateEnum


data class UserDetail(
    val name: String,
    val userGarbageIcon: StateEnum? = StateEnum.TIME,
    val userSmallIcon: StateEnum? = null
)