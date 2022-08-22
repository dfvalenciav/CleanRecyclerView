package co.cristian.bizumdialog.presentation.main

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.UserDetailPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.UserPresentation


sealed class UserEvent {
    class ListMain(val ls: List<UserPresentation>): UserEvent()
    class ListMainDetail(val ls: List<UserDetailPresentation>) : UserEvent()
}