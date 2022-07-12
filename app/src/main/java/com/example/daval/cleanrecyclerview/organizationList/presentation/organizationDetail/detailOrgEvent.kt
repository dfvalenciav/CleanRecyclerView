package com.example.daval.cleanrecyclerview.organizationList.presentation.organizationDetail

sealed class detailOrgEvent {
    class detailOrgName(val orgDetailName: String) : detailOrgEvent()
}
