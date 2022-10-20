package com.makeevrserg.mvvmcore.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Allows to reduce boilerplate code using viewBinding
 */
abstract class BindingFragment<T : ViewBinding>(private val bindingFactory: (LayoutInflater) -> T) :
    Fragment() {

    protected var binding: T? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = bindingFactory(inflater).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let(::onBinding)
    }

    open fun onBinding(binding: T) {

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}