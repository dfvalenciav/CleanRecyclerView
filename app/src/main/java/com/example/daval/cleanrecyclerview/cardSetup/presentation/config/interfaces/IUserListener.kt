package com.example.daval.cleanrecyclerview.cardSetup.presentation.config.interfaces

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.ConfigPresentation


interface IUserListener {

    fun onClick(data: ConfigPresentation, enable: Boolean)
}