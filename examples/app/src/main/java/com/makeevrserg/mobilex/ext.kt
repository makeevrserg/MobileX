package com.makeevrserg.mobilex

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
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