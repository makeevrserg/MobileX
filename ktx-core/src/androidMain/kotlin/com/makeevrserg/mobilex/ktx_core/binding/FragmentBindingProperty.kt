package com.makeevrserg.mobilex.ktx_core.binding

import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty

class FragmentBindingProperty<T : ViewBinding>(
    @LayoutRes id:Int,
    bindingFactory: (View) -> T
) : BindingProperty<T, Fragment>(id) {
    override val bindingFactory: (Fragment) -> T = {
        bindingFactory(it.requireView())
    }
}

inline fun <reified T : ViewBinding> Fragment.viewBinding(
    @LayoutRes id:Int,
    noinline bindingFactory: (View) -> T
): ReadOnlyProperty<Fragment, T> = FragmentBindingProperty(id, bindingFactory)