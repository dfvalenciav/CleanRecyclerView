package com.example.daval.cleanrecyclerview.organizationList.presentation.organizationList

import com.example.daval.cleanrecyclerview.organizationList.presentation.models.OrgPresentation

sealed class OrgEvent {
    class ListOrg (val ls: List<OrgPresentation>) : OrgEvent()
}