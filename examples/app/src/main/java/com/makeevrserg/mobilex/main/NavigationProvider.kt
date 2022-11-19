package com.makeevrserg.mobilex.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mobilex.presentation.list.ListFragment
import com.makeevrserg.mobilex.presentation.main.MainFragment
import com.makeevrserg.mobilex.presentation.stack.StackFragment

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