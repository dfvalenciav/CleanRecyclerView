package com.example.daval.cleanrecyclerview.organizationList.presentation.organizationDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daval.cleanrecyclerview.base.BaseViewModel


class DetailOrgViewModel : BaseViewModel<detailOrgEvent>() {
    private val _text = MutableLiveData<String>().apply {
        value = "hello redsys"
    }
    val text: LiveData<String> = _text
}