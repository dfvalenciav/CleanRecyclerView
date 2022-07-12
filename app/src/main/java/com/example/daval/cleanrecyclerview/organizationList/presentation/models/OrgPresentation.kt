package com.example.daval.cleanrecyclerview.organizationList.presentation.models


data class OrgPresentation(
    var organizationName: String?,
    var organizationCode : String?
) : java.io.Serializable

fun equals(oldItem: OrgPresentation, newItem: OrgPresentation): Boolean =
    oldItem.organizationName == newItem.organizationName && oldItem.organizationCode == newItem.organizationCode

