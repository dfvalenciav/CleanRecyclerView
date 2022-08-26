package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

data class ConfigPresentation(
    var position: StateEnum? = null,
    var title: String,
    var message: String,
    var image: Int,
    var backGround: Int,
    var indicatorSwitch: Boolean

)
fun equals(oldItem: ConfigPresentation, newItem: ConfigPresentation): Boolean =
    oldItem.title == newItem.title && oldItem.message == newItem.message
            && oldItem.image == newItem.image && oldItem.backGround == newItem.backGround
            && oldItem.indicatorSwitch == newItem.indicatorSwitch