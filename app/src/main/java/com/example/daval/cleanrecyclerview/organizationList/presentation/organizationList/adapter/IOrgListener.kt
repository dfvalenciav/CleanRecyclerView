package com.example.daval.cleanrecyclerview.organizationList.presentation.organizationList.adapter

import com.example.daval.cleanrecyclerview.organizationList.presentation.models.OrgPresentation

interface IOrgListener {
    fun onClickOrg( dataPassed: OrgPresentation)
}