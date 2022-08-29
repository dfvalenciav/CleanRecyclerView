package com.example.daval.cleanrecyclerview.cardSetup.presentation.cardListFinishRegister

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.databinding.FragmentCardListFinishRegisterBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CardListFinishRegisterFragment : BaseFragment<FragmentCardListFinishRegisterBinding, CardListFinishRegisterViewModel>() {

    override val viewModel by viewModels<CardListFinishRegisterViewModel> ()

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCardListFinishRegisterBinding.inflate(inflater, container, false)

    override fun setListeners() {
        binding.btnCardListFinishRegisterContinue.setOnClickListener {
            val action = CardListFinishRegisterFragmentDirections.actionCardListFinishRegisterFragmentToMainFragment()
            binding.btnCardListFinishRegisterContinue.findNavController().navigate(action)
        }
    }

    override fun observe() {

    }

}