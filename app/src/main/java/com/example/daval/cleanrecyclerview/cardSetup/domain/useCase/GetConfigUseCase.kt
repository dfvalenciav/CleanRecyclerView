package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase


import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.data.repository.CardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Config
import javax.inject.Inject


class GetConfigUseCase @Inject constructor(
    private val repository: CardRealmRepository
): BaseUseCase<Config>(){

    override suspend fun execute(): List<Config> {
        return repository.getListConfig()
    }

}