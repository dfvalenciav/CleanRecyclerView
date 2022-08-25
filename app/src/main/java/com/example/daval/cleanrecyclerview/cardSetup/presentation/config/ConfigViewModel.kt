package com.example.daval.cleanrecyclerview.cardSetup.presentation.config


import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetConfigUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListConfigPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConfigViewModel @Inject constructor(
    private val getConfigUseCase: GetConfigUseCase
) : BaseViewModel<ConfigEvent>() {



    fun getConfigList() {
        executeUseCase(
            {
                getConfigUseCase.execute()
            },
            { getConfigUseCase ->
                getConfigUseCase.toListConfigPresentation()
                    .also { presentationConfigList ->
                        _event.value = ConfigEvent.ListConfig(presentationConfigList)
                    }
            }
        )
    }
}