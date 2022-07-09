package com.example.daval.cleanrecyclerview.presentation.organizationList.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.daval.cleanrecyclerview.base.BaseAdapter
import com.example.daval.cleanrecyclerview.base.BaseViewHolder
import com.example.daval.cleanrecyclerview.databinding.OrgListItemBinding
import com.example.daval.cleanrecyclerview.domain.models.Org
import com.example.daval.cleanrecyclerview.presentation.models.OrgPresentation
import com.example.daval.cleanrecyclerview.presentation.models.equals


class OrgAdapter (private val listener : IOrgListener)
    : BaseAdapter<OrgPresentation, OrgAdapter.OrgViewHolder> (diffCallback) {

    override fun onBindViewHolder(holder: OrgAdapter.OrgViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.onClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OrgViewHolder(
        OrgListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
    )


    /**
     * ViewHolder matching OrgPresentation instances with bindingListItemVeiew ids
     */
    inner class OrgViewHolder (
        private val binding : OrgListItemBinding
            ): BaseViewHolder<OrgPresentation>(binding) {
        override fun bind(data: OrgPresentation) {
            binding.apply {
                organizationName.text = data.organizationName
                organizationCode.text = data.organizationCode
            }
        }
        fun onClick(){
            binding.root.setOnClickListener { listener.onClickOrg() }
        }
    }

    companion object {
        private val diffCallback = object: DiffUtil.ItemCallback<OrgPresentation>(){
            override fun areItemsTheSame(
                oldItem: OrgPresentation,
                newItem: OrgPresentation
            ): Boolean = equals(oldItem, newItem)

            override fun areContentsTheSame(
                oldItem: OrgPresentation,
                newItem: OrgPresentation
            ): Boolean = oldItem.organizationName == newItem.organizationName
                    && oldItem.organizationCode == oldItem.organizationCode
        }
    }

}