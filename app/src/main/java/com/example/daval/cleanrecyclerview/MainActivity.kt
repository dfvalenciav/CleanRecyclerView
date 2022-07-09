package com.example.daval.cleanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.daval.cleanrecyclerview.base.BaseActivity
import com.example.daval.cleanrecyclerview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateView(inflater: LayoutInflater) =
            ActivityMainBinding.inflate(inflater)

    override fun setUI() {
        binding.navHostFragment.findNavController()
            .setGraph(R.navigation.navigation)
    }

}