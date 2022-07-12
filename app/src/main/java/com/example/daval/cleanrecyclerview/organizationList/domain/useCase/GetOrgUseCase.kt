package com.example.daval.cleanrecyclerview.organizationList.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.organizationList.data.repository.OrgRepository
import com.example.daval.cleanrecyclerview.organizationList.domain.models.Org


//inject repository, inject data sourc
class GetOrgUseCase (
    private val repository : OrgRepository
) : BaseUseCase<Org>(){
    override suspend fun execute(): List<Org> {
        return repository.getOrgList()
    }

}