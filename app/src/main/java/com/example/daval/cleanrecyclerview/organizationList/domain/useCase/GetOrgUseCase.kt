package com.example.daval.cleanrecyclerview.organizationList.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.organizationList.data.repository.OrgRepository
import com.example.daval.cleanrecyclerview.organizationList.domain.models.Org
import javax.inject.Inject


//inject repository, inject data sourc
class GetOrgUseCase @Inject constructor(
    private val repository : OrgRepository
) : BaseUseCase<Org>(){
    override suspend fun execute(): List<Org> {
        return repository.getOrgList()
    }
}