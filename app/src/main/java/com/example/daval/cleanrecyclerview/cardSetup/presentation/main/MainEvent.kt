package com.example.daval.cleanrecyclerview.cardSetup.presentation.main

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.ConfigPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.UserDetailPresentation
import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.UserPresentation


sealed class MainEvent {
    class ListMain(val ls: List<UserPresentation>): MainEvent()
    class ListMainDetail(val ls: List<UserDetailPresentation>) : MainEvent()
    class ListConfig(val ls: List<ConfigPresentation>):MainEvent()
}