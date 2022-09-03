package com.example.daval.cleanrecyclerview.cardCarrousel.data.local

import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.cardCarrousel.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Config
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.TypeConfigEnum

class MockDataBaseCards {

    fun config():List<Config> = listOf(
        Config(TypeConfigEnum.TOUCH_ID,"Touch ID","Utiliza tu huella para acceder a la App de una forma rápida y segura.", R.drawable.ic_fingerprint,R.drawable.bg_light_orange,false),
        Config(TypeConfigEnum.PAGO_MOVIL,"Pago móvil","Realiza tus compras con el móvil sin necesidad de usar tu tarjeta.", R.drawable.ic_pay_mobile,R.drawable.bg_light_purple,false)
    )

    fun cardListCarrousel() : List<CardCarrousel> = listOf (
        CardCarrousel(R.drawable.ic_favicon_copy_4_white,"BBVA", "123456789087656787", "Valido hasta 09/25", R.drawable.ic_visa_vector, R.color.card_color_type1),
        CardCarrousel(R.drawable.ic_favicon_copy_4_white,"SANTANDER", "385569503998764530", "Valido hasta 01/26", R.drawable.ic_mastercard_vector, R.color.card_color_type2),
        CardCarrousel(R.drawable.ic_favicon_copy_4_white,"CAIXA", "988544879087495038", "Valido hasta 04/24", R.drawable.ic_visa_vector, R.color.card_color_type3),
        CardCarrousel(R.drawable.ic_favicon_copy_4_white,"SABADELL", "123456789087656787", "Valido hasta 09/25", R.drawable.ic_visa_vector, R.color.card_color_type4),
        CardCarrousel(R.drawable.ic_favicon_copy_4_white,"BANKIA", "385569503998764530", "Valido hasta 01/26", R.drawable.ic_mastercard_vector, R.color.card_color_type5),
        CardCarrousel(R.drawable.ic_favicon_copy_4_white,"BAKINTER", "988544879087495038", "Valido hasta 04/24", R.drawable.ic_mastercard_vector, R.color.card_color_type6),
        CardCarrousel(R.drawable.ic_favicon_copy_4_white,"DEUTSCHE BANK", "548753215488785654", "Valido hasta 04/24", R.drawable.ic_mastercard_vector, R.color.card_color_type7),
        CardCarrousel(R.drawable.ic_favicon_copy_4_white,"CAJAMAR", "988544879087495038", "Valido hasta 04/24", R.drawable.ic_visa_vector, R.color.card_color_type8),
    )
}