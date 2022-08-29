package com.example.daval.cleanrecyclerview.utils

import androidx.fragment.app.FragmentActivity
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.Otp
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.Simple
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.OtpDialogPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.SimpleDialogPresentation


fun FragmentActivity?.showOtpDialog(model: OtpDialogPresentation.Builder): Otp {
    val dialog = Otp()
    dialog.modelDialog = model
    this?.let {
        dialog.show(it.supportFragmentManager, Otp::class.java.name)
    }
    return dialog
}

fun FragmentActivity?.showSimpleDialog(model: SimpleDialogPresentation.Builder): Simple {
    val dialog = Simple()
    dialog.modelDialog = model
    this?.let {
        dialog.show(it.supportFragmentManager, Simple::class.java.name)
    }
    return dialog
}

