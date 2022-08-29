package com.example.daval.cleanrecyclerview.cardSetup.presentation.organizationList

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.OrgPresentation

sealed class OrgEvent {
    class ListOrg (val ls: List<OrgPresentation>) : OrgEvent()
}