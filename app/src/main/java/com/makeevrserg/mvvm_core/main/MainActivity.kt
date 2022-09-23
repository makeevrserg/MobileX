package com.makeevrserg.mvvm_core.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Screen
import com.makeevrserg.mvvm_core.R
import com.makeevrserg.mvvm_core.createNavigator
import com.makeevrserg.mvvm_core.main.App.Companion.cicerone
import com.makeevrserg.mvvm_core.main.App.Companion.navigatorHolder
import com.makeevrserg.mvvm_core.main.App.Companion.router

class MainActivity : AppCompatActivity() {
    private val navigation: Navigator =
        cicerone.createNavigator(this, R.id.fragmentContainer, supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            router.newRootScreen(NavigationProvider.Main as Screen)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigation)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}