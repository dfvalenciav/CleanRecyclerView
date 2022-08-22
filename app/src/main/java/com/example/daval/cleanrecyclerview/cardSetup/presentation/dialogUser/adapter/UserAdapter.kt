package com.example.daval.cleanrecyclerview.cardSetup.presentation.dialogUser.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.base.BaseAdapter
import com.example.daval.cleanrecyclerview.base.BaseViewHolder
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.UserPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.equals
import com.example.daval.cleanrecyclerview.databinding.HolderItemUserBinding

class UserAdapter :
    BaseAdapter<UserPresentation, UserAdapter.UserViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        HolderItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    inner class UserViewHolder(
        private val binding: HolderItemUserBinding
    ) : BaseViewHolder<UserPresentation>(binding) {
        @SuppressLint("SetTextI18n")
        override fun bind(data: UserPresentation) {
            binding.apply {

                tvName.text = data.name
                tvNumber.text = data.numPhone
                Glide.with(root.context)
                    .load(data.userImage)
                    .error(R.drawable.ic_bizum)
                    .placeholder(R.drawable.ic_bizum)
                    .into(ivPhoto)
            }
        }

    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<UserPresentation>() {
            override fun areItemsTheSame(
                oldItem: UserPresentation,
                newItem: UserPresentation
            ): Boolean = equals(oldItem, newItem)


            override fun areContentsTheSame(
                oldItem: UserPresentation,
                newItem: UserPresentation
            ): Boolean = oldItem.name == newItem.name && oldItem.numPhone == newItem.numPhone
                    && oldItem.userImage == newItem.userImage

        }
    }


}