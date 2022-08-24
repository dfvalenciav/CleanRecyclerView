package com.example.daval.cleanrecyclerview.cardSetup.presentation.main


import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetConfigUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetDetailUserUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetUserUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListConfigPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListUserDetailPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListUserPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getDetailUserUseCase: GetDetailUserUseCase,
    private val getConfigUseCase: GetConfigUseCase
) : BaseViewModel<MainEvent>() {



    fun getConfigList() {
        executeUseCase(
            {
                getConfigUseCase.execute()
            },
            { getConfigUseCase ->
                getConfigUseCase.toListConfigPresentation()
                    .also { presentationConfigList ->
                        _event.value = MainEvent.ListConfig(presentationConfigList)
                    }
            }
        )
    }


    fun getUserList() {
        executeUseCase(
            {
                getUserUseCase.execute()
            },
            { getUserUseCase ->
                getUserUseCase.toListUserPresentation()
                    .also { presentationUserList ->
                        _event.value = MainEvent.ListMain(presentationUserList)
                    }
            },
        )
    }

    fun getDetailUserList() {
        executeUseCase(
            {
                getDetailUserUseCase.execute()
            },
            { getDetailUserUseCase ->
                getDetailUserUseCase.toListUserDetailPresentation()
                    .also { presentationUserDetailList ->
                        _event.value = MainEvent.ListMainDetail(presentationUserDetailList)
                    }

            },
        )
    }
}