package com.makeevrserg.mvvm_core.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mvvm_core.presentation.main.MainFragment
import com.makeevrserg.mvvm_core.presentation.stack.StackFragment
import com.makeevrserg.mvvmcore.core.routing.INavigationProvider
import com.makeevrserg.mvvmcore.core.routing.IScreenProvider

object NavigationProvider {
    val Main: IScreenProvider = object : FragmentScreen, IScreenProvider {
        override fun createFragment(factory: FragmentFactory): Fragment = MainFragment()

    }
    val Stack: IScreenProvider = object : FragmentScreen, IScreenProvider {
        override fun createFragment(factory: FragmentFactory): Fragment = StackFragment()

    }
}