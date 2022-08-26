package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.interfaces.ICardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Org
import javax.inject.Inject


class GetOrgUseCase @Inject constructor(
    private val repository : ICardRealmRepository
) : BaseUseCase<Org>(){

    override suspend fun execute(): List<Org> {
        return repository.getOrgList()
    }
}