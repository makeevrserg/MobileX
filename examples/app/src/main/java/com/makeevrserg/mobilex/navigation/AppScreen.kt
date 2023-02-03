package com.makeevrserg.mobilex.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.makeevrserg.mobilex.presentation.list.ListFragment
import com.makeevrserg.mobilex.presentation.main.MainFragment

object AppScreen {
    val Main = FragmentScreen {
        MainFragment()
    }
    val List = FragmentScreen {
        ListFragment()
    }
}