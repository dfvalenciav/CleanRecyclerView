package com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.base.BaseDialog
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.SimpleDialogPresentation
import com.example.daval.cleanrecyclerview.databinding.DialogSimpleBinding

class Simple : BaseDialog() {

    var modelDialog = SimpleDialogPresentation.Builder()

    var onClickButton: (click: String) -> Unit = {}


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val activity = this.activity ?: return super.onCreateDialog(savedInstanceState)
        val dialog = Dialog(activity)

        val binding = DialogSimpleBinding.inflate(activity.layoutInflater)

        modelDialog.build()

        with(binding) {
            if (modelDialog.image != null) {
                imgDialogSimpleError.visibility = View.VISIBLE
            } else {
                imgDialogSimpleError.visibility = View.GONE
                Glide.with(root.context)
                    .load(modelDialog.image)
                    .placeholder(R.drawable.ic_bizum)
                    .into(imgDialogSimpleError)
            }

            tvDialogSimpleTitle.text = modelDialog.title
            tvDialogSimpleMessage.text = modelDialog.subTitle

            if (modelDialog.message.isNullOrBlank()) {
                tvDialogSimpleMessage.visibility = View.GONE
            } else {
                tvDialogSimpleMessage.visibility = View.VISIBLE
                tvDialogSimpleMessage.text = modelDialog.message
            }


            btnDialogSimpleAccept.text = modelDialog.btnConfirm

            if (modelDialog.btnCancel.isNullOrBlank()) {
                btnDialogSimpleCancel.visibility = View.GONE
            } else {
                btnDialogSimpleCancel.visibility = View.VISIBLE
                btnDialogSimpleCancel.text = modelDialog.btnCancel
            }

            btnDialogSimpleAccept.setOnClickListener {
                modelDialog.btnConfirm?.let { it1 -> onClickButton(it1) }
                dismiss()
            }

            btnDialogSimpleCancel.setOnClickListener {
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

    //Funcion para determiner el ancho del dialogo -> Por defecto es el 90% del ancho
    private fun calculateWidth(percent: Double): Double {
        return resources.displayMetrics.widthPixels * percent
    }


}