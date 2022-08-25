package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListFinishRegister

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
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListSelected.CardListSelectedFragmentDirections
import com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListTrustDevice.CardListTrustDeviceViewModel
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListFinishRegisterBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CardListFinishRegisterFragment : BaseFragment<FragmentCardListFinishRegisterBinding, CardListFinishRegisterViewModel>() {

    override val viewModel by viewModels<CardListFinishRegisterViewModel> ()

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCardListFinishRegisterBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun setListeners() {
        binding.materialButtonCardListFinishRegister.setOnClickListener {
            //val action = CardListFinishRegisterFragmentDirections.actionCardListFinishRegisterFragmentToCardListHomeFragment()
            // binding.materialButtonCardListFinishRegister.findNavController().navigate(action)
            val action = CardListFinishRegisterFragmentDirections.actionCardListFinishRegisterFragmentToMainFragment()
            binding.materialButtonCardListFinishRegister.findNavController().navigate(action)
        }
    }

    override fun observe() {

    }

}