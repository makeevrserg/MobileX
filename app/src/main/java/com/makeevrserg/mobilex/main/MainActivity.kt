package com.makeevrserg.mobilex.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.makeevrserg.mobilex.R
import com.makeevrserg.mobilex.createNavigator
import com.makeevrserg.mobilex.modules.CiceroneModule
import com.makeevrserg.mobilex.modules.NavigationHolderModule
import com.makeevrserg.mobilex.modules.RouterModule

class MainActivity : AppCompatActivity() {
    private val router: Router = RouterModule.value
    private val cicerone: Cicerone<Router> = CiceroneModule.value
    private val navigatorHolder: NavigatorHolder = NavigationHolderModule.value

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