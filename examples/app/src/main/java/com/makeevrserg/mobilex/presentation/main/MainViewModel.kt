package com.makeevrserg.mobilex.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makeevrserg.mobilex.main.NavigationProvider
import com.makeevrserg.mobilex.presentation.compose.ComposeScreen
import com.makeevrserg.mobilex.presentation.compose.ExampleComposeActivity
import com.makeevrserg.mobilex.ktx_core.*
import com.makeevrserg.mobilex.ktx_core.action.ActionContainer
import com.makeevrserg.mobilex.ktx_core.action.ActionContainerHost
import com.makeevrserg.mobilex.ktx_core.action.IActionContainer
import com.makeevrserg.mobilex.ktx_core.action.components.RouteInfo
import com.makeevrserg.mobilex.ktx_core.action.components.UiText
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID


class MainViewModel : ViewModel(), ActionContainerHost {
    override val actionContainer: IActionContainer = ActionContainer()
    fun onBasicNavigationClicked() = viewModelScope.launch {
        RouteInfo.NextScreen(NavigationProvider.Stack).navigate()
    }

    fun onShowToastClicked() = viewModelScope.launch {
        UiText.DynamicString("Toast").sendToast()
    }

    fun onShoSnackbarClicked() = viewModelScope.launch {
        UiText.DynamicString("Snackbar").sendSnackbar()
    }

    fun onShowLoadingClicked() = viewModelScope.launch {
        setLoading(true)
        delay(2000)
        setLoading(false)
    }

    fun openComposeScreen() = viewModelScope.launch {
        RouteInfo.NextScreen(ComposeScreen.Custom(UUID.randomUUID().toString())).navigate()
    }

    fun onShowDialogClicked() = viewModelScope.launch {
        UIDialogMessage(
            title = UiText.DynamicString("Some Title"),
            description = UiText.DynamicString("Some Description"),
            isCancellable = false,
            positiveButton = UIDialogMessage.UIDialogButton(
                text = UiText.DynamicString("Positive"),
                ::clearUiDialog
            ),
            negativeButton = UIDialogMessage.UIDialogButton(
                text = UiText.DynamicString("Negative"),
                ::clearUiDialog
            )
        ).send()
    }

    fun onListOpenClicked() = viewModelScope.launch {
        RouteInfo.NextScreen(NavigationProvider.List).navigate()
    }

    fun onComposeActivityClicked() = viewModelScope.launch {
        RouteInfo.Intent(ExampleComposeActivity::class.java).navigate()
    }


}