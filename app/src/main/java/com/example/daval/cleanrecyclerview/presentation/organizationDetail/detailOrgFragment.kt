package com.example.daval.cleanrecyclerview.presentation.organizationDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.databinding.FragmentDetailOrgBinding

class detailOrgFragment() : BaseFragment<FragmentDetailOrgBinding, detailOrgViewModel> () {

    override val viewModel by viewModels<detailOrgViewModel> ()

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDetailOrgBinding.inflate(inflater, container, false)

    override fun observe() {
       viewModel.text.observe(viewLifecycleOwner, Observer {
           with(binding){
               detailOrgaFragment.text = it
           }
       })
    }


}