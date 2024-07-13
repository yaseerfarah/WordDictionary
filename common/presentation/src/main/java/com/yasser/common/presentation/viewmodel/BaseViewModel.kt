package com.yasser.common.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

open class BaseViewModel <UI_Effect> : ViewModel() {

    private val _uiEffect = Channel<UI_Effect>()
    val uiEffect = _uiEffect.receiveAsFlow()

    fun sendEffect(effect: UI_Effect) {
        viewModelScope.launch {
            _uiEffect.send(effect)
        }
    }
}