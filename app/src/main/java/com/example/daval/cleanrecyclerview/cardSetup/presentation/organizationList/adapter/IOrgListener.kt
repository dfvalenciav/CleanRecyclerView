package com.example.daval.cleanrecyclerview.cardSetup.presentation.organizationList.adapter

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.OrgPresentation

interface IOrgListener {
    fun onClickOrg( dataPassed: OrgPresentation)
}