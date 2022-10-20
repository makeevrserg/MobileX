package com.makeevrserg.mvvm_core.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mvvm_core.presentation.list.ListFragment
import com.makeevrserg.mvvm_core.presentation.main.MainFragment
import com.makeevrserg.mvvm_core.presentation.stack.StackFragment

object NavigationProvider {
    val Main = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = MainFragment()
    }

    val Stack = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = StackFragment()

    }
    val List = object : FragmentScreen {
        override fun createFragment(factory: FragmentFactory): Fragment = ListFragment()

    }
}