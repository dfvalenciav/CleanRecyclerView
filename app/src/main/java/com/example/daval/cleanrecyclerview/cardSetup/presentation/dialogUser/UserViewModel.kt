package co.cristian.bizumdialog.presentation.main


import com.example.daval.cleanrecyclerview.base.BaseViewModel
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetDetailUserUseCase
import com.example.daval.cleanrecyclerview.cardSetup.domain.useCase.GetUserUseCase
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListUserDetailPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.mappers.toListUserPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getDetailUserUseCase: GetDetailUserUseCase
) : BaseViewModel<UserEvent>() {


    fun getUserList() {
        executeUseCase(
            {
                getUserUseCase.execute()
            },
            { getUserUseCase ->
                getUserUseCase.toListUserPresentation()
                    .also { presentationUserList ->
                        _event.value = UserEvent.ListMain(presentationUserList)
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
                        _event.value = UserEvent.ListMainDetail(presentationUserDetailList)
                    }

            },
        )
    }
}