package com.example.daval.cleanrecyclerview.presentation.mappers

import com.example.daval.cleanrecyclerview.domain.models.Org
import com.example.daval.cleanrecyclerview.presentation.models.OrgPresentation

fun Org.toOrgPresentation() = OrgPresentation(name, code)

fun List<Org>.toListOrgPresentation() = map {
    domain -> domain.toOrgPresentation()
}