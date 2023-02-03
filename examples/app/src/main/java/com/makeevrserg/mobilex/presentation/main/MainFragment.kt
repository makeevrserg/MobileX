package com.makeevrserg.mobilex.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.makeevrserg.mobile.di_container.getValue
import com.makeevrserg.mobilex.R
import com.makeevrserg.mobilex.databinding.FragmentMainBinding
import com.makeevrserg.mobilex.modules.Modules
import com.makeevrserg.mobilex.navigation.AppScreen


class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by lazy { MainViewModel() }
    private val router by Modules.ciceroneRouter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("BINDING", "onViewCreated")
        with(binding) {
            bListFragment.setOnClickListener {
                router.navigateTo(AppScreen.List)
            }
        }
    }


}


