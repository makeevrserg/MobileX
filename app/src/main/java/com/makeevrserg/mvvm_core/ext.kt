package com.makeevrserg.mvvm_core

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewbinding.ViewBinding
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mvvm_core.main.App
import com.makeevrserg.mvvm_core.main.CiceroneNavigationProvider
import com.makeevrserg.mvvmcore.core.presentation.CoreBindingFragment
import com.makeevrserg.mvvmcore.core.presentation.CoreViewModel
import com.makeevrserg.mvvmcore.core.presentation.intent_manager.CoreIntentManager
import com.makeevrserg.mvvmcore.core.presentation.progress_dialog.CoreProgressDialog
import com.makeevrserg.mvvmcore.core.presentation.ui_dialog.CoreAlertUiDialog

/**
 * Создает базову навигацию используя [container] в качест layout для фрагментов
 */
fun Cicerone<Router>.createNavigator(
    activity: AppCompatActivity,
    @IdRes container: Int,
    supportFragmentManager: FragmentManager
) = object : AppNavigator(
    activity,
    container,
    supportFragmentManager
) {
    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)

        super.setupFragmentTransaction(
            screen,
            fragmentTransaction,
            currentFragment,
            nextFragment
        )
    }
}

fun <T : ViewBinding, K : CoreViewModel> CoreBindingFragment<T, K>.lazyIntentManager(): Lazy<CoreIntentManager<K>> =
    lazy {
        CoreIntentManager<K>(
            viewModel = viewModel,
            contextProvider = { context },
            progressDialogProvider = { CoreProgressDialog },
            alertDialogProvider = { CoreAlertUiDialog },
            navigationProvider = CiceroneNavigationProvider(App.router)
        )
    }