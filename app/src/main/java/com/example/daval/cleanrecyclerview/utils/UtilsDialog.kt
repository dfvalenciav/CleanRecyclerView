package com.example.daval.cleanrecyclerview.utils

import androidx.fragment.app.FragmentActivity
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.DataList
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.Otp
import com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs.Simple
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.DataListDialog
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.OtpDialog
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.SimpleDialog


fun FragmentActivity?.showOtpDialog(model: OtpDialog.Builder): Otp {
    val dialog = Otp()
    dialog.modelDialog = model
    this?.let {
        dialog.show(it.supportFragmentManager, Otp::class.java.name)
    }
    return dialog
}

fun FragmentActivity?.showSimpleDialog(model: SimpleDialog.Builder): Simple {
    val dialog = Simple()
    dialog.modelDialog = model
    this?.let {
        dialog.show(it.supportFragmentManager, Simple::class.java.name)
    }
    return dialog
}

fun FragmentActivity?.showRvDialog(model: DataListDialog.Builder<Any>): DataList<Any> {
    val dialog = DataList<Any>()
    dialog.modelDialog = model
    this?.let {
        dialog.show(it.supportFragmentManager, Simple::class.java.name)
    }
    return dialog
}