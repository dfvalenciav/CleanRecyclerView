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
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.SimpleDialog
import com.example.daval.cleanrecyclerview.databinding.DialogSimpleBinding

class Simple : BaseDialog() {

    var modelDialog = SimpleDialog.Builder()

    var onClickButton: (click: String) -> Unit = {}


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val activity = this.activity ?: return super.onCreateDialog(savedInstanceState)
        val dialog = Dialog(activity)

        val binding = DialogSimpleBinding.inflate(activity.layoutInflater)

        modelDialog.build()

        with(binding) {
            if (modelDialog.image != null) {
                imgDialog.visibility = View.VISIBLE
            } else {
                imgDialog.visibility = View.GONE
                Glide.with(root.context)
                    .load(modelDialog.image)
                    .placeholder(R.drawable.ic_bizum)
                    .into(imgDialog)
            }

            tvTitle.text = modelDialog.title
            tvSubTitle.text = modelDialog.subTitle

            if(modelDialog.message.isNullOrBlank()){
                tvMessage.visibility = View.GONE
            }else{
                tvMessage.visibility = View.VISIBLE
                tvMessage.text = modelDialog.message
            }


            btnAccept.text = modelDialog.btnConfirm

            if(modelDialog.btnCancel.isNullOrBlank()){
                btnCancel.visibility = View.GONE
            }else {
                btnCancel.visibility = View.VISIBLE
                btnCancel.text = modelDialog.btnCancel
            }

            btnAccept.setOnClickListener {
                dismiss()
            }

            btnCancel.setOnClickListener {
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