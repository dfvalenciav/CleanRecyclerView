package com.example.daval.cleanrecyclerview.presentation.organizationList

import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.domain.useCase.GetOrgUseCase
import com.example.daval.cleanrecyclerview.presentation.mappers.toListOrgPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrganizationViewModel2 @Inject constructor(
    private val getOrgUseCase: GetOrgUseCase
) : BaseViewModel<OrgEvent>() {

    fun getOrgList() {
        executeUseCase(
            {
                getOrgUseCase.execute()
            },
            {
                getOrgUseCase ->
                getOrgUseCase.toListOrgPresentation()
                    .also {
                        presentationOrgList ->
                        _event.value = OrgEvent.ListOrg(presentationOrgList)
                    }
            }
        )
    }
}

