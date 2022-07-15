package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.daval.cleanrecyclerview.base.BaseAdapter
import com.example.daval.cleanrecyclerview.base.BaseViewHolder
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.equals
import com.example.daval.cleanrecyclerview.databinding.CardListAvailableItemBinding

class CardSetupAdapter (private val listener: ICardSetupListener)
    : BaseAdapter<CardSetupPresentation, CardSetupAdapter.CardSetupHolder> (diffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CardSetupHolder (
        CardListAvailableItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
    )

   inner class CardSetupHolder(private val binding: CardListAvailableItemBinding) : BaseViewHolder<CardSetupPresentation> (binding) {
       override fun bind(data: CardSetupPresentation) {
           binding.apply {
               cardAvailableType.text = data.cardListType
               cardAvailableNumber.text= data.cardListNumber
               root.setOnClickListener {
                   listener.onClickCardSetup(data)
               }

           }
       }
   }


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<CardSetupPresentation>() {
            override fun areItemsTheSame(
                oldItem: CardSetupPresentation,
                newItem: CardSetupPresentation
            ): Boolean = equals(
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


