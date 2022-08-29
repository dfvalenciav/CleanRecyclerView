package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListTrustDevice

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListTrustDeviceBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CardListTrustDeviceFragment: BaseFragment<FragmentCardListTrustDeviceBinding, CardListTrustDeviceViewModel>() {


    override val viewModel by viewModels<CardListTrustDeviceViewModel> ()

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCardListTrustDeviceBinding.inflate(inflater, container, false)

    override fun setListeners() {
        binding.btnCardListTrustDeviceContinue.setOnClickListener {
            val action = CardListTrustDeviceFragmentDirections.actionCardListTrustDeviceFragmentToCardListFinishRegisterFragment()
            binding.btnCardListTrustDeviceContinue.findNavController().navigate(action)
        }
    }

    override fun observe() {
        Log.d("tag", "data fixed")
    }
}