package com.example.daval.cleanrecyclerview.cardSetup.presentation.models

data class UserPresentation(
    var name: String,
    var numPhone: String,
    var userImage: String
)


fun equals(oldItem: UserPresentation, newItem: UserPresentation): Boolean =
    oldItem.name == newItem.name && oldItem.numPhone == newItem.numPhone
            && oldItem.userImage == newItem.userImage