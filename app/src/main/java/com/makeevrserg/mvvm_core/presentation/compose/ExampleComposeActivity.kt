package com.makeevrserg.mvvm_core.presentation.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.makeevrserg.mvvm_core.presentation.compose.components.ConfirmDialog
import com.makeevrserg.mvvm_core.presentation.compose.components.MyLoadingIndication
import com.makeevrserg.mvvm_core.presentation.compose.components.RowButon
import com.makeevrserg.mvvm_core.presentation.main.MainViewModel
import com.makeevrserg.mvvmcore.core.ui.UIDialogMessage
import com.makeevrserg.mvvmcore.core.lazyViewModel
import com.makeevrserg.mvvmcore.core_compose.asString
import com.makeevrserg.mvvmcore.core_compose.ui.UIDialogListener
import com.makeevrserg.mvvmcore.core_compose.ui.UiLoadingListener
import com.makeevrserg.mvvmcore.core_compose.ui.UiMessageListener

class ExampleComposeActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberAnimatedNavController()
            val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
                "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
            }
            Navigation(navController = navController, viewModelStoreOwner = viewModelStoreOwner)
        }
    }
}







