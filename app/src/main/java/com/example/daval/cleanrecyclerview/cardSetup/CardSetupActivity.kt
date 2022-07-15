package com.example.daval.cleanrecyclerview.cardSetup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.findNavController
import com.example.daval.cleanrecyclerview.R
import com.example.daval.cleanrecyclerview.base.BaseActivity
import com.example.daval.cleanrecyclerview.databinding.ActivityCardSetupBinding
import com.example.daval.cleanrecyclerview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardSetupActivity : BaseActivity<ActivityCardSetupBinding> (){
    override fun inflateView(inflater: LayoutInflater) =
        ActivityCardSetupBinding.inflate(inflater)

    override fun setUI() {
       binding.navHostFragment.findNavController()
           .setGraph(R.navigation.navigation_card_setup)
    }
}