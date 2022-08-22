package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.UserDetail
import javax.inject.Inject

class GetDetailUserUseCase @Inject constructor(
    private val repository: CardRealmRepository
) : BaseUseCase<UserDetail>(){

    override suspend fun execute(): List<UserDetail> {
        return repository.getListUserDetail()
    }
}