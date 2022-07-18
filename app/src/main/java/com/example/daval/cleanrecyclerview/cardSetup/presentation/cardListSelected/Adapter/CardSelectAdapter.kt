package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.daval.cleanrecyclerview.base.BaseAdapter
import com.example.daval.cleanrecyclerview.base.BaseViewHolder
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import com.example.daval.cleanrecyclerview.databinding.CardListSelectedItemBinding

class CardSelectAdapter (private val listener : ICardSelectListener)
    : BaseAdapter<CardSetupPresentation, CardSelectAdapter.CardSelectHolder> (diffCallback) {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ) = CardSelectHolder(
        CardListSelectedItemBinding.inflate(
            LayoutInflater.from(parent.context) , parent, false)
    )

    inner class CardSelectHolder (private val binding: CardListSelectedItemBinding) :
        BaseViewHolder<CardSetupPresentation>(binding) {
        override fun bind(data: CardSetupPresentation) {
            with(binding){
                cardSelectType.text = data.cardListType
                cardSelectNumber.text = data.cardListNumber
            }
        }

    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<CardSetupPresentation>() {
            override fun areItemsTheSame(
                oldItem: CardSetupPresentation,
                newItem: CardSetupPresentation
            ): Boolean = com.example.daval.cleanrecyclerview.cardSetup.presentation.models.equals(
                oldItem,
                newItem
            )

            override fun areContentsTheSame(
                oldItem: CardSetupPresentation,
                newItem: CardSetupPresentation
            ): Boolean = oldItem.cardListType == newItem.cardListType
                    && oldItem.cardListNumber == newItem.cardListNumber && oldItem.cardListPrefered == newItem.cardListPrefered
        }
    }


}