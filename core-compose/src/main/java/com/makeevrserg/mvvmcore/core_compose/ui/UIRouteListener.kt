package com.makeevrserg.mvvmcore.core_compose.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.makeevrserg.mvvmcore.core.routing.IRouter
import com.makeevrserg.mvvmcore.core.ui.route.IUIRouteAction
import com.makeevrserg.mvvmcore.core.ui.route.IUiRouteListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun <T> UIRouteListener(
    action: IUIRouteAction,
    navHostRouter: IRouter<T>
) {
    val context = LocalContext.current
    val routeListener = object : IUiRouteListener<T> {
        override val navigationProvider: IRouter<T> = navHostRouter
        override val contextProvider: () -> Context? = { context }
    }
    val uiRoute = action.uiRoute.collectAsState()
    uiRoute.value.value?.let {
        LaunchedEffect(key1 = it) {
            withContext(Dispatchers.Main) {
                routeListener.navigate(it)
            }
        }
    }

}
