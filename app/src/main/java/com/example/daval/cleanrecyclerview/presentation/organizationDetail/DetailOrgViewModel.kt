package com.example.daval.cleanrecyclerview.presentation.organizationDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.databinding.FragmentDetailOrgBinding
import com.example.daval.cleanrecyclerview.presentation.organizationList.OrgEvent

class DetailOrgViewModel : BaseViewModel<OrgEvent>() {
    private val _text = MutableLiveData<String>().apply {
        value = "hello redsys"
    }
    val text: LiveData<String> = _text
}