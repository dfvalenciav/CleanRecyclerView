package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListHome.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.daval.cleanrecyclerview.base.BaseAdapter
import com.example.daval.cleanrecyclerview.base.BaseViewHolder
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation
import com.example.daval.cleanrecyclerview.databinding.CardListHomeItemBinding

class CardHomeAdapter : BaseAdapter<CardHomeOptionsPresentation, CardHomeAdapter.CardHomeHolder>(diffCallback){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ) = CardHomeHolder(
        CardListHomeItemBinding.inflate(
            LayoutInflater.from(parent.context) , parent, false)
    )

    inner class CardHomeHolder (private val binding: CardListHomeItemBinding) :
        BaseViewHolder<CardHomeOptionsPresentation>(binding) {

        @SuppressLint("DiscouragedApi")
        override fun bind(data:CardHomeOptionsPresentation ) {
            with(binding){
                tvCardListHomeItemTitle.text = data.cardHomeTitle
                tvCardListHomeItemDescription.text = data.cardHomeDescription
                with(imgCardListHomeItemIcon) { setImageResource(resources.getIdentifier(data.cardHomeIcon, "drawable", "com.example.daval.cleanrecyclerview")) }
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<CardHomeOptionsPresentation>() {
            override fun areItemsTheSame(
                oldItem: CardHomeOptionsPresentation,
                newItem: CardHomeOptionsPresentation
            ): Boolean = com.example.daval.cleanrecyclerview.cardSetup.presentation.models.equals(
                oldItem,
                newItem
            )

            override fun areContentsTheSame(
                oldItem: CardHomeOptionsPresentation,
                newItem: CardHomeOptionsPresentation
            ): Boolean = oldItem.cardHomeTitle == newItem.cardHomeTitle
                    && oldItem.cardHomeDescription == newItem.cardHomeDescription
        }
    }
}