package com.example.daval.cleanrecyclerview.cardSetup.domain.useCase


import com.example.daval.cleanrecyclerview.base.BaseUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.interfaces.ICardRealmRepository
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Config
import javax.inject.Inject


class GetConfigUseCase @Inject constructor(
    private val repository: ICardRealmRepository
): BaseUseCase<Config>(){

    override suspend fun execute(): List<Config> {
        return repository.getListConfig()
    }

}