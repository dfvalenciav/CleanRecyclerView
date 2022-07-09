package com.example.daval.cleanrecyclerview.presentation.models

data class OrgPresentation(
    var organizationName: String?,
    var organizationCode : String?
)

fun equals(oldItem: OrgPresentation, newItem: OrgPresentation): Boolean =
    oldItem.organizationName == newItem.organizationName && oldItem.organizationCode == newItem.organizationCode

