package com.example.daval.cleanrecyclerview.cardSetup.presentation.config

import com.example.daval.cleanrecyclerview.cardSetup.presentation.models.ConfigPresentation


sealed class ConfigEvent {
    class ListConfig(val ls: List<ConfigPresentation>):ConfigEvent()
}