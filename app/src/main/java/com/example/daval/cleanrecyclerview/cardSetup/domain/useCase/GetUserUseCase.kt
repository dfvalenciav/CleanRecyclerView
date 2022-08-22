package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase

import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.User
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: CardRealmRepository
) : BaseUseCase<User>() {


    override suspend fun execute(): List<User> {
        return repository.getListUser()
    }
}