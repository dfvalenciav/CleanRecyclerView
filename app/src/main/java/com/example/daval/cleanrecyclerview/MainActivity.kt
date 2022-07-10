package com.example.daval.cleanrecyclerview


import android.view.LayoutInflater
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.base.BaseActivity
import com.example.daval.cleanrecyclerview.databinding.ActivityMainBinding

import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateView(inflater: LayoutInflater) =
            ActivityMainBinding.inflate(inflater)

    override fun setUI() {
        binding.navHostFragment.findNavController()
            .setGraph(R.navigation.navigation)
    }

}