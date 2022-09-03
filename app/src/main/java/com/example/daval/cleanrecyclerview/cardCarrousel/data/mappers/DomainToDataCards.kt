package com.example.daval.cleanrecyclerview.cardCarrousel.data.mappers

import com.example.daval.cleanrecyclerview.cardCarrousel.data.models.RCardCarrousel
import com.example.daval.cleanrecyclerview.cardCarrousel.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.data.local.realm.*
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.*
import java.util.*


/**REALM*/
fun CardCarrousel.toRCardCarrousel() = RCardCarrousel(BankLogo,BankName,CardNumber,CardExpiration,CardFranchise, CardBackground, UUID.randomUUID().mostSignificantBits)
fun List<CardCarrousel>.toRListCardCarrouselEntity()= map { domain ->
    domain.toRCardCarrousel()
}