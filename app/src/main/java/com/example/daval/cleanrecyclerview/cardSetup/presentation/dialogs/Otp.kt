package com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import com.example.daval.cleanrecyclerview.base.BaseDialog
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.OtpDialog
import com.example.daval.cleanrecyclerview.databinding.DialogOtpBinding

class Otp : BaseDialog() {

    var modelDialog = OtpDialog.Builder()

    var onClickButton: (click: String) -> Unit = {}

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val activity = this.activity ?: return super.onCreateDialog(savedInstanceState)
        val dialog = Dialog(activity)

        val binding = DialogOtpBinding.inflate(activity.layoutInflater)

        modelDialog.build()

        with(binding) {
            tvTitleOtp.text = modelDialog.title
            tvMessageOtp.text = modelDialog.message
            btnAcceptOtp.text = modelDialog.btnConfirm
            btnCancelOtp.text = modelDialog.btnCancel

            btnAcceptOtp.setOnClickListener {
                modelDialog.btnConfirm?.let { it1 -> onClickButton(it1) }
                dismiss()
            }

            btnCancelOtp.setOnClickListener {
                modelDialog.btnCancel?.let { it1 -> onClickButton(it1) }
                dismiss()
            }
        }


        dialog.setContentView(binding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setLayout(calculateWidth(0.9).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.show()
        return dialog

    }

    //Funcion para determinar el ancho del dialogo -> Por defecto es el 90% del ancho
    private fun calculateWidth(percent: Double): Double {
        return resources.displayMetrics.widthPixels * percent
    }
}