package com.makeevrserg.mobilex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobilex.modules.Modules
import com.makeevrserg.mobilex.navigation.AppScreen
import com.makeevrserg.mobilex.navigation.createNavigator

class MainActivity : AppCompatActivity() {
    private val router: Router by Modules.ciceroneRouter
    private val cicerone: Cicerone<Router> by Modules.cicerone
    private val navigatorHolder: NavigatorHolder by Modules.navigationHolder

    private val navigation: Navigator =
        cicerone.createNavigator(this, R.id.fragmentContainer, supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            router.newRootScreen(AppScreen.Main)
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