package com.example.daval.cleanrecyclerview.cardSetup.presentation.CardListHome.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.Utils.Utils
import com.example.daval.cleanrecyclerview.base.BaseAdapter
import com.example.daval.cleanrecyclerview.base.BaseViewHolder
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardHomeOptionsPresentation
import com.example.daval.cleanrecyclerview.databinding.CardListHomeItemBinding

class CardHomeAdapter (private val listener : ICardHomeListener)
    : BaseAdapter<CardHomeOptionsPresentation, CardHomeAdapter.CardHomeHolder>(diffCallback){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ) = CardHomeHolder(
        CardListHomeItemBinding.inflate(
            LayoutInflater.from(parent.context) , parent, false)
    )

    inner class CardHomeHolder (private val binding: CardListHomeItemBinding) :
        BaseViewHolder<CardHomeOptionsPresentation>(binding) {

        override fun bind(data:CardHomeOptionsPresentation ) {
            with(binding){
                cardHomeTitle.text = data.cardHomeTitle
                cardHomeDescription.text = data.cardHomeDescription
                with(cardHomeIconimageView) { setImageResource(resources.getIdentifier(data.cardHomeIcon, "drawable", "com.example.daval.cleanrecyclerview")) }
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