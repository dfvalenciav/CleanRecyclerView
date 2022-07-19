package com.example.daval.cleanrecyclerview.Utils

import android.content.Context
import android.widget.Toast

class Utils {

    fun showToast (context: Context, text: String) {
        Toast.makeText(context,text,Toast.LENGTH_LONG).show()
    }

    fun hideCardNumber (text: String): String {
        text.length
        val newText = text.replaceRange(4,14,"*****")
        return newText
    }
}