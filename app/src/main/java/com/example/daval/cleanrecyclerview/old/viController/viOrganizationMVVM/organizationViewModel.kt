package com.example.daval.cleanrecyclerview.old.viController.viOrganizationMVVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daval.cleanrecyclerview.old.viController.viModel.dataModel

class organizationViewModel : ViewModel() {
    var organizationArray : ArrayList<dataModel>  = ArrayList()
    var _organizationLiveData : MutableLiveData<ArrayList<dataModel>>
    val organiztionMutableLiveData: MutableLiveData<ArrayList<dataModel>>
    get() = _organizationLiveData

    init {
        _organizationLiveData = MutableLiveData<ArrayList<dataModel>>()
        populateList()
        _organizationLiveData.value = organizationArray
    }

    fun populateList()  {
        val organization = dataModel("Nombre organización", "000000")
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
    }
}
