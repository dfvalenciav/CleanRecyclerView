package com.example.daval.cleanrecyclerview.cardSetup.presentation.config.interfaces

import com.example.daval.cleanrecyclerview.databinding.HolderItemConfigurationBinding


interface IUserListener {

    fun onClick(position: Int, holder : HolderItemConfigurationBinding)
}