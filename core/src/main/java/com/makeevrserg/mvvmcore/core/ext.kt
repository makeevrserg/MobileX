package com.makeevrserg.mvvmcore.core

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.Serializable

fun <T> Flow<T>.collectOn(
    lifecycleOwner: LifecycleOwner,
    scope: CoroutineDispatcher = Dispatchers.Main,
    action: suspend CoroutineScope.(value: T) -> Unit
): Job = lifecycleOwner.lifecycleScope.launch(scope) {
    collect {
        action(it)
    }
}
/**
 * Было бы логично сделать авто-создание для ViewModel'ей в абстрактном классе, но в случае изменения механики в создании - придется менять все Fragment'ы
 * В случае с этой функцией - менять все не придется
 */
inline fun <reified T : ViewModel> HasDefaultViewModelProviderFactory.lazyViewModel(): Lazy<T> = lazy {
    defaultViewModelProviderFactory.create(T::class.java)
}

inline fun <reified T: Serializable> simpleName() = T::class.java.simpleName

inline fun <reified T : Serializable> Bundle.getSerializable(): T? =
    getSerializable(this, simpleName<T>(), T::class.java)

fun <T : Serializable> getSerializable(bundle: Bundle, key: String, clazz: Class<T>): T? {
    return if (Build.VERSION.SDK_INT >= 33) {
        bundle.getSerializable(key, clazz)
    } else bundle.getSerializable(key) as? T?
}

suspend fun <T> withGenericAttempt(maxAmount: Int, block: suspend () -> T?): T? {
    var attemptsLeft = maxAmount
    var result = block()
    while (result == null && attemptsLeft > 0) {
        result = block()
        attemptsLeft--
    }
    return result
}