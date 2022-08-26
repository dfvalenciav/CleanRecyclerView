package com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogs

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daval.cleanrecyclerview.base.BaseDialog
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.DataListDialog
import com.example.daval.cleanrecyclerview.databinding.DialogDataListBinding


class DataList<T> : BaseDialog(){

    var modelDialog = DataListDialog.Builder<T>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val activity = this.activity ?: return super.onCreateDialog(savedInstanceState)
        val dialog= Dialog(activity)

        val binding = DialogDataListBinding.inflate(activity.layoutInflater)

        modelDialog.build()

        with(binding){
            tvDialogSimpleTitle.text = modelDialog.title
            imgDialogDataListClose.setOnClickListener { dismiss() }
            modelDialog.listData?.let { setAdapter(binding, it) }
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

    private fun setAdapter(binding: DialogDataListBinding, ls: List<T>) {
        with(binding.rvDialogDataList) {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(
                    this@DataList.requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                adapter = modelDialog.adapter
            }
            (modelDialog.adapter)?.submitList(ls)
        }
    }


}