package com.example.daval.cleanrecyclerview.cardSetup.data.mappers

import com.example.daval.cleanrecyclerview.cardSetup.data.local.entity.CardSetupEntity
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup


    fun CardSetupEntity.toCardSetup() = CardSetup(type,number,preferred,amount,clientName,clientId)
    fun List<CardSetupEntity>.toListCardSetup() = map { data ->
        data.toCardSetup()}