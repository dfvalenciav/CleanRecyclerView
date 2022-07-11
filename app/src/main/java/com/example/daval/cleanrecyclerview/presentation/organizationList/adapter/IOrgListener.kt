package com.example.daval.cleanrecyclerview.presentation.organizationList.adapter

import com.example.daval.cleanrecyclerview.presentation.models.OrgPresentation

interface IOrgListener {
    fun onClickOrg( dataPassed: OrgPresentation)
}