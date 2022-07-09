package com.example.daval.cleanrecyclerview.presentation.organizationList

import com.example.daval.cleanrecyclerview.presentation.models.OrgPresentation

sealed class OrgEvent {
    class ListOrg (val ls: List<OrgPresentation>) : OrgEvent()
}