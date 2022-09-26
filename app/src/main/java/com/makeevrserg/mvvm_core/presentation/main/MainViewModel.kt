package com.makeevrserg.mvvm_core.presentation.main

import androidx.lifecycle.viewModelScope
import com.makeevrserg.mvvm_core.main.NavigationProvider
import com.makeevrserg.mvvm_core.presentation.compose.ExampleComposeActivity
import com.makeevrserg.mvvmcore.core.UIDialogButton
import com.makeevrserg.mvvmcore.core.UIDialogMessage
import com.makeevrserg.mvvmcore.core.UIMessage
import com.makeevrserg.mvvmcore.core.UiText
import com.makeevrserg.mvvmcore.core.presentation.CoreViewModel
import com.makeevrserg.mvvmcore.core.routing.RouteInfo
import com.makeevrserg.mvvmcore.core.singleLiveEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : CoreViewModel() {
    fun onBasicNavigationClicked() {
        _nextRoute.value = RouteInfo.NextScreen(NavigationProvider.Stack).singleLiveEvent()
    }

    fun onShowToastClicked() {
        val toastUiText = UiText.DynamicString("Toast")
        _uiMessage.value = UIMessage.Toast(toastUiText).singleLiveEvent()
    }

    fun onShoSnackbarClicked() {
        val toastUiText = UiText.DynamicString("Snackbar")
        _uiMessage.value = UIMessage.SnackBar(toastUiText).singleLiveEvent()
    }

    fun onShowLoadingClicked() = viewModelScope.launch {
        _loadingIndicator.value = true
        delay(2000)
        _loadingIndicator.value = false
    }


    fun onShowDialogClicked() {
        _uiDialogMessage.value = UIDialogMessage(
            title = UiText.DynamicString("Some Title"),
            description = UiText.DynamicString("Some Description"),
            positiveButton = UIDialogButton(
                text = UiText.DynamicString("Positive")
            ){
                _uiDialogMessage.value = null
            },
            negativeButton = UIDialogButton(
                text = UiText.DynamicString("Negative")
            ){
                _uiDialogMessage.value = null
            }
        )
    }

    fun onListOpenClicked() {
        _nextRoute.value = RouteInfo.NextScreen(NavigationProvider.List).singleLiveEvent()
    }

    fun onCompsoeActivityClicked() {
        _nextRoute.value = RouteInfo.Intent(ExampleComposeActivity::class.java).singleLiveEvent()
    }
}