package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

class UserDetailPresentation(
    var name: String,
    var userGarbageIcon: StateEnum? = StateEnum.TIME,
    var userSmallIcon: StateEnum? = null

)
fun equals(oldItem: UserDetailPresentation, newItem: UserDetailPresentation): Boolean =
    oldItem.name == newItem.name && oldItem.userSmallIcon == newItem.userSmallIcon
            && oldItem.userGarbageIcon == newItem.userGarbageIcon
