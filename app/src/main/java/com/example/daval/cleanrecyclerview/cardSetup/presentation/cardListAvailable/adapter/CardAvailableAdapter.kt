package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.adapter

import android.util.Log
import android.util.Log.VERBOSE
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import com.example.daval.cleanrecyclerview.Utils.Utils
import com.example.daval.cleanrecyclerview.base.BaseAdapter
import com.example.daval.cleanrecyclerview.base.BaseViewHolder
import com.example.daval.cleanrecyclerview.cardSetup.domain.models.CardSetup
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.CardSetupPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.equals
import com.example.daval.cleanrecyclerview.databinding.CardListAvailableItemBinding

class CardAvailableAdapter (private val listener: ICardListPreferred)
    : BaseAdapter<CardSetupPresentation, CardAvailableAdapter.CardAvailableHolder> (diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CardAvailableHolder (
        CardListAvailableItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
    )

   inner class CardAvailableHolder(private val binding: CardListAvailableItemBinding) : BaseViewHolder<CardSetupPresentation> (binding) {

       override fun bind(data: CardSetupPresentation) {
           var util = Utils()
           binding.apply {
               cardAvailableType.text = data.cardListType
               cardAvailableNumber.text= util.hideCardNumber(data.cardListNumber?:"")
               switchMobilePayment.setOnClickListener {
                   if (switchMobilePayment.isChecked){
                       listener.addPreferredCard(data)
                   }
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


