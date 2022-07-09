package com.example.daval.cleanrecyclerview.base

import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

abstract class BaseDialog: DialogFragment() {

    override fun show(manager: FragmentManager, tag: String?) {
        val fragment = manager.findFragmentByTag(tag)
        val ft = manager.beginTransaction()
        if(fragment != null){
            ft.remove(fragment)
            ft.commitAllowingStateLoss()
        }
        try {
            super.show(manager, tag)
        }catch (exception: Exception){
           Log.e(BaseDialog::class.java.name,exception.stackTraceToString())
        }
    }

    override fun onStart() {
        super.onStart()
        isCancelable=false
    }
}