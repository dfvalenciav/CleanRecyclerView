package com.example.daval.cleanrecyclerview.cardSetup.presentation.config.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.daval.cleanrecyclerview.base.BaseAdapter
import com.example.daval.cleanrecyclerview.base.BaseViewHolder
import com.example.daval.cleanrecyclerview.cardSetup.presentation.config.interfaces.IUserListener
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.ConfigPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.equals
import com.example.daval.cleanrecyclerview.databinding.HolderItemConfigurationBinding

class ConfigurationAdapter(private val listener: IUserListener) :
    BaseAdapter<ConfigPresentation, ConfigurationAdapter.ConfigurationViewHolder>(
        diffCallBack
    ) {

    override fun onBindViewHolder(holder: ConfigurationViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.onClick(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ConfigurationViewHolder(
        HolderItemConfigurationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    inner class ConfigurationViewHolder(
        private val binding: HolderItemConfigurationBinding
    ) : BaseViewHolder<ConfigPresentation>(binding) {
        @SuppressLint("SetTextI18n")
        override fun bind(data: ConfigPresentation) {
            binding.apply {

                tvHolderItemConfigTitle.text = data.title
                tvHolderItemConfigMessage.text = data.message
                swtHolderItemConfigStatus.isChecked = data.indicatorSwitch
                if(data.indicatorSwitch) tvHolderItemConfigStatus.text = "Activado" else tvHolderItemConfigStatus.text = "Desactivado"
                loadDrawable(imgHolderItemConfigBackground, data.backGround, root.context)
                loadDrawable(imgHolderItemConfigResource, data.image, root.context)
            }
        }
        fun onClick(
            holder: ConfigurationViewHolder
        ){
            binding.swtHolderItemConfigStatus.setOnClickListener {
                    listener.onClick(holder.binding)

            }
        }
    }



    private fun loadDrawable(img: ImageView, id: Int, context: Context) {
        Glide.with(context)
            .load(id)
            .into(img)
    }


    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<ConfigPresentation>() {
            override fun areItemsTheSame(
                oldItem: ConfigPresentation,
                newItem: ConfigPresentation
            ): Boolean = equals(oldItem, newItem)


            override fun areContentsTheSame(
                oldItem: ConfigPresentation,
                newItem: ConfigPresentation
            ): Boolean =
                oldItem.title == newItem.title && oldItem.message == newItem.message
                        && oldItem.image == newItem.image && oldItem.backGround == newItem.backGround
                        && oldItem.indicatorSwitch == newItem.indicatorSwitch

        }
    }
}