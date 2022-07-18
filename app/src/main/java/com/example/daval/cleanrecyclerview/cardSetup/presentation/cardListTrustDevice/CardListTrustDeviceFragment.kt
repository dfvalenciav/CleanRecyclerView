package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListTrustDevice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListAvailable.CardListAvailableViewModel
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected.CardListSelectedFragmentDirections
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListTrustDeviceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardListTrustDeviceFragment() : BaseFragment<FragmentCardListTrustDeviceBinding, CardListTrustDeviceViewModel>() {


    override val viewModel by viewModels<CardListTrustDeviceViewModel> ()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.materialButtonCardListTrustDevice.setOnClickListener {
            val action = CardListTrustDeviceFragmentDirections.actionCardListTrustDeviceFragmentToCardListFinishRegisterFragment()
            binding.materialButtonCardListTrustDevice.findNavController().navigate(action)
        }
    }
    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCardListTrustDeviceBinding.inflate(inflater, container, false)

    override fun observe() {
        Log.d("hello", "hello")
    }
}