package com.makeevrserg.mobilex.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.makeevrserg.mobilex.main.NavigationProvider
import com.makeevrserg.mobilex.presentation.compose.ComposeScreen
import com.makeevrserg.mobilex.presentation.compose.ExampleComposeActivity
import com.makeevrserg.mobilex.core.ui.UIDialogButton
import com.makeevrserg.mobilex.core.ui.UIDialogMessage
import com.makeevrserg.mobilex.core.ui.UIMessage
import com.makeevrserg.mobilex.core.routing.RouteInfo
import com.makeevrserg.mobilex.core.ui.UiText
import com.makeevrserg.mobilex.core.ui.SingleLiveEvent
import com.makeevrserg.mobilex.core.ui.dialog.IUIDialogAction
import com.makeevrserg.mobilex.core.ui.emptyLiveEvent
import com.makeevrserg.mobilex.core.ui.loading.IUILoadingAction
import com.makeevrserg.mobilex.core.ui.message.IUIMessageAction
import com.makeevrserg.mobilex.core.ui.route.IUIRouteAction
import com.makeevrserg.mobilex.core.ui.nullableStateFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID


class MainViewModel : ViewModel(), IUIRouteAction, IUIDialogAction, IUILoadingAction,
    IUIMessageAction {
    override val uiMessage: MutableStateFlow<SingleLiveEvent<UIMessage>> by emptyLiveEvent()
    override val uiDialog: MutableStateFlow<UIDialogMessage?> by nullableStateFlow()
    override val uiLoading: MutableStateFlow<Boolean> = MutableStateFlow<Boolean>(false)
    override val uiRoute: MutableStateFlow<SingleLiveEvent<RouteInfo>> by emptyLiveEvent()
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

    fun openComposeScreen(){
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