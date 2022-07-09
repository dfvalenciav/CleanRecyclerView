package com.example.daval.cleanrecyclerview.presentation.organizationDetail

sealed class detailOrgEvent {
    class detailOrgName(val orgDetailName: String) : detailOrgEvent()
}
