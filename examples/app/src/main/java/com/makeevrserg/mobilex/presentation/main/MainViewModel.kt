package com.makeevrserg.mobilex.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makeevrserg.mobilex.main.NavigationProvider
import com.makeevrserg.mobilex.presentation.compose.ComposeScreen
import com.makeevrserg.mobilex.presentation.compose.ExampleComposeActivity
import com.makeevrserg.mobilex.ktx_core.*
import com.makeevrserg.mobilex.ktx_core.ui.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID


class MainViewModel : ViewModel(),
    IUIRouteAction by UIRouteAction(),
    IUIDialogAction by UIDialogAction(),
    IUILoadingAction by UILoadingAction(),
    IUIMessageAction by UIMessageAction() {
    fun onBasicNavigationClicked() {
        RouteInfo.NextScreen(NavigationProvider.Stack).navigate()
    }

    fun onShowToastClicked() {
        UiText.DynamicString("Toast").sendToast()
    }

    fun onShoSnackbarClicked() {
        UiText.DynamicString("Snackbar").sendSnackbar()
    }

    fun onShowLoadingClicked() = viewModelScope.launch {
        setLoading(true)
        delay(2000)
        setLoading(false)
    }

    fun openComposeScreen() {
        RouteInfo.NextScreen(ComposeScreen.Custom(UUID.randomUUID().toString())).navigate()
    }

    fun onShowDialogClicked() {
        UIDialogMessage(
            title = UiText.DynamicString("Some Title"),
            description = UiText.DynamicString("Some Description"),
            isCancellable = false,
            positiveButton = UIDialogButton(
                text = UiText.DynamicString("Positive"),
                ::clearUiDialog
            ),
            negativeButton = UIDialogButton(
                text = UiText.DynamicString("Negative"),
                ::clearUiDialog
            )
        ).send()
    }

    fun onListOpenClicked() {
        RouteInfo.NextScreen(NavigationProvider.List).navigate()
    }

    fun onComposeActivityClicked() {
        RouteInfo.Intent(ExampleComposeActivity::class.java).navigate()
    }


}