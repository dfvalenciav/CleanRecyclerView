package com.example.daval.cleanrecyclerview.organizationList.presentation.mappers

import com.example.daval.cleanrecyclerview.organizationList.domain.models.Org
import com.example.daval.cleanrecyclerview.organizationList.presentation.models.OrgPresentation

fun Org.toOrgPresentation() = OrgPresentation(name, code)

fun List<Org>.toListOrgPresentation() = map {
    domain -> domain.toOrgPresentation()
}