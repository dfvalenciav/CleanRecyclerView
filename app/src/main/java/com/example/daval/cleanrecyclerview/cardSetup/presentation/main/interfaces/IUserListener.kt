package com.example.daval.cleanrecyclerview.cardSetup.presentation.main.interfaces

import com.example.daval.cleanrecyclerview.databinding.HolderItemConfigurationBinding


interface IUserListener {

    fun onClickUser(position: Int, holder : HolderItemConfigurationBinding)

    //fun onClick(boolean: Boolean): Boolean
}