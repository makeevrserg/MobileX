package com.makeevrserg.mobilex.ktx_core.binding

import android.os.Handler
import android.os.Looper
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class BindingProperty<T : ViewBinding, VIEW : LifecycleOwner>(@LayoutRes val id:Int) : ReadOnlyProperty<VIEW, T> {
    private var viewBinding: T? = null
    private val lifecycleObserver = BindingLifecycleObserver()

    protected abstract val bindingFactory: (VIEW) -> T

    @MainThread
    override fun getValue(thisRef: VIEW, property: KProperty<*>): T {
        this.viewBinding?.let { return it }
        thisRef.lifecycle.addObserver(lifecycleObserver)
        return bindingFactory(thisRef).also {
            viewBinding = it
        }
    }


    private inner class BindingLifecycleObserver : DefaultLifecycleObserver {
        private val mainHandler = Handler(Looper.getMainLooper())
        override fun onPause(owner: LifecycleOwner) {
            super.onPause(owner)
            clear(owner)
        }

        @MainThread
        override fun onDestroy(owner: LifecycleOwner) {
            super.onDestroy(owner)
            clear(owner)
        }

        fun clear(owner: LifecycleOwner){
            owner.lifecycle.removeObserver(this)
            mainHandler.post { viewBinding = null }
        }
    }
    companion object{
        inline fun <reified T : ViewBinding,VIEW:LifecycleOwner> viewBindingFactory(
            @LayoutRes id:Int,
            noinline bindingFactory: (VIEW) -> T,
            noinline onBinding: (T) -> Unit
        ): BindingProperty<T, VIEW> = object : BindingProperty<T, VIEW>(id){
            override val bindingFactory: (VIEW) -> T = bindingFactory
        }
    }
}