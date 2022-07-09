package com.example.daval.cleanrecyclerview.presentation.organizationList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.domain.useCase.GetOrgUseCase
import com.example.daval.cleanrecyclerview.presentation.mappers.toListOrgPresentation
import com.example.daval.cleanrecyclerview.viModel.dataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class organizationViewModel2 @Inject constructor(
    private val getOrgUseCase: GetOrgUseCase
) : BaseViewModel<OrgEvent>() {

    fun getOrgList() {
        executeUseCase(
            {
                getOrgUseCase.execute()
            },
            {
                getOrgUseCase ->
                getOrgUseCase.toListOrgPresentation()
                    .also {
                        presentationOrgList ->
                        _event.value = OrgEvent.ListOrg(presentationOrgList)
                    }
            }
        )
    }
}
/*class organizationViewModel2 : ViewModel() {
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
        val organization = dataModel("BBVA", "000000")
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
        organizationArray.add(organization)
    }
}*/
