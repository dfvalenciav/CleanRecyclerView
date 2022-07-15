package com.example.daval.cleanrecyclerview.organizationList.presentation.organizationDetail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.daval.cleanrecyclerview.base.BaseFragment
import com.example.daval.cleanrecyclerview.databinding.FragmentDetailOrgBinding
//import com.example.daval.cleanrecyclerview.organizationList.presentation.organizationDetail.DetailOrgFragmentArgs

class DetailOrgFragment() : BaseFragment<FragmentDetailOrgBinding, DetailOrgViewModel>() {

    override val viewModel by viewModels<DetailOrgViewModel> ()

    //val safeArgs : DetailOrgFragmentArgs by navArgs()
   // val dataReceived = safeArgs.orgItem.organizationName


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDetailOrgBinding.inflate(inflater, container, false)


    override fun observe() {
       viewModel.text.observe(viewLifecycleOwner, Observer {
           with(binding){
               detailOrgaFragment.text = it.toString()
               Log.d("test", "nothing" )
           }
       })
    }


}