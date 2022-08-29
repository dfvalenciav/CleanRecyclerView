package com.example.daval.cleanrecyclerview.cardSetup.data.local

import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardCarrousel
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardHomeTask
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Config
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.Org
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.StateEnum

class MockDataBase {

    fun config():List<Config> = listOf(
        Config(StateEnum.TOUCH_ID,"Touch ID","Utiliza tu huella para acceder a la App de una forma rápida y segura.", R.drawable.ic_fingerprint,R.drawable.bg_light_orange,false),
        Config(StateEnum.PAGO_MOVIL,"Pago móvil","Realiza tus compras con el móvil sin necesidad de usar tu tarjeta.", R.drawable.ic_pay_mobile,R.drawable.bg_light_purple,false)
    )

    fun cardListSetup(): List<CardSetup> = listOf(
        CardSetup("Tarjeta de crèdito", "123456789087656787",false,10000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de dèbito", "385569503998764530",false,20000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de dèbito", "129369503098574038",false,15000,"Pedro Pèrez", 321567765),
        CardSetup("Tarjeta de crèdito", "988544879087495038",false,2000,"Pedro Pèrez", 321567765)
    )

    fun cardListHome() : List<CardHomeTask> = listOf(
        CardHomeTask("Actividad", "Movimientos de la tarjeta", "ic_icon_tarjeta_actividad"),
        CardHomeTask("Pago seguro", "Actividad entre el 22/07/21 al 23/07/21", "ic_icon_tarjeta_pago_seguro"),
        CardHomeTask("Roaming", "Uso fuera de Europa desactivado", "ic_icon_tarjeta_roaming"),
        CardHomeTask("CVV Dinámico", "Pago seguro", "ic_icon_tarjeta_cvv_dinamico")
    )

    fun cardListCarrousel() : List<CardCarrousel> = listOf (
        CardCarrousel("ic_favicon_copy_4_white","BBVA", "123456789087656787", "Valido hasta 09/25", "ic_visa_vector", "#FFBB86FC"),
        CardCarrousel("ic_favicon_copy_4_white","SANTANDER", "385569503998764530", "Valido hasta 01/26", "ic_mastercard_vector", "#FF3700B3"),
        CardCarrousel("ic_favicon_copy_4_white","CAIXA", "988544879087495038", "Valido hasta 04/24", "ic_visa_vector", "#000000"),
        CardCarrousel("ic_favicon_copy_4_white","SABADELL", "123456789087656787", "Valido hasta 09/25", "ic_visa_vector", "#FF018786"),
        CardCarrousel("ic_favicon_copy_4_white","BANKIA", "385569503998764530", "Valido hasta 01/26", "ic_mastercard_vector", "#e8c227"),
        CardCarrousel("ic_favicon_copy_4_white","BAKINTER", "988544879087495038", "Valido hasta 04/24", "ic_visa_vector", "#000C66"),
        CardCarrousel("ic_favicon_copy_4_white","DEUTSCHE BANK", "548753215488785654", "Valido hasta 04/24", "ic_visa_vector", "#EADDCA"),
        CardCarrousel("ic_favicon_copy_4_white","CAJAMAR", "988544879087495038", "Valido hasta 04/24", "ic_visa_vector", "#01579b"),
    )


    fun organizations(): List<Org> = listOf(
        Org("BBVA", "111111", "+000-000-0000", 1234, "Valencia", 100000),
        Org("Santander", "222222", "+123-000-0000", 1025, "Madrid", 200000),
        Org("Sanitas", "333333", "+564-000-0000", 4422, "Barcelona", 15000),
        Org("IKEA", "444444", "+468-000-0000", 4321, "Valencia", 100000),
        Org("Zara", "555555", "+685-000-0000", 1025, "Cadiz", 150000),
        Org("Telefonica", "666666", "+732-000-0000", 145, "Ibiza", 15000),
        Org("CaixaBank", "777777", "+558-000-0000", 6655, "Valencia", 100000),
        Org("Iberdrola", "888888", "+654-000-0000", 5874, "Sevilla", 200000),
        Org("Sanitas", "333333", "+564-000-0000", 4422, "Barcelona", 15000),
    )

}