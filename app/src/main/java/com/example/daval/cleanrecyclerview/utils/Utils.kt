package com.example.daval.cleanrecyclerview.utils

import android.content.Context
import android.view.View
import com.example.daval.cleanrecyclerview.R
import com.google.android.material.snackbar.Snackbar

class Utils {


    fun showSnack (view: View, context: Context, text: String, textAction: String?) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG)
            .setAction(textAction) {
            }
            .setActionTextColor(context.getColor(R.color.secundario_06_bg_gray))
            .setBackgroundTint(context.getColor(R.color.Primario_01_SMM_Purple))
            .show()
    }

    fun hideCardNumber(text: String): String {
        text.length
        return text.replaceRange(4, 14, "*****")
    }
}