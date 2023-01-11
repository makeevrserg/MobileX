package com.makeevrserg.mobilex.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.makeevrserg.mobilex.CoreProgressDialog
import com.makeevrserg.mobilex.R
import com.makeevrserg.mobilex.actions.CiceroneListener
import com.makeevrserg.mobilex.actions.LoadingDialogListener
import com.makeevrserg.mobilex.ktx_core.binding.viewBinding
import com.makeevrserg.mobilex.databinding.FragmentMainBinding
import com.makeevrserg.mobilex.defaultFragmentViewProvider
import com.makeevrserg.mobilex.ktx_core.action.UIMessageListener
import com.makeevrserg.mobilex.modules.RouterModule



class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(R.layout.fragment_main,FragmentMainBinding::bind)

    private val viewModel: MainViewModel by lazy { MainViewModel() }
    private val fragmentViewProvider = defaultFragmentViewProvider()
    private val uiMessageListener = UIMessageListener(lifecycleScope,fragmentViewProvider)
    private val ciceroneListener = CiceroneListener(RouterModule.value,lifecycleScope,fragmentViewProvider)
    private val loadingDialogListener = LoadingDialogListener(lifecycleScope,fragmentViewProvider){
        CoreProgressDialog.build(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uiMessageListener.collect(viewModel.actionContainer)
        loadingDialogListener.collect(viewModel.actionContainer)
        ciceroneListener.collect(viewModel.actionContainer)
        Log.d("BINDING", "onViewCreated")
        with(binding){
            bShowDialog.setOnClickListener {
                Log.d("BINDING", "bShowDialog")
                viewModel.onShowDialogClicked()
            }
            bShowLoading.setOnClickListener {
                viewModel.onShowLoadingClicked()
            }
            bShowSnackBar.setOnClickListener {
                viewModel.onShoSnackbarClicked()
            }
            bShowToast.setOnClickListener {
                viewModel.onShowToastClicked()
            }
            bNavigation.setOnClickListener {
                viewModel.onBasicNavigationClicked()
            }
            bListFragment.setOnClickListener {
                viewModel.onListOpenClicked()
            }
            bComposeActivity.setOnClickListener {
                viewModel.onComposeActivityClicked()
            }
        }
    }


}


