package com.makeevrserg.mvvmcore.core.ui

import android.view.View

interface IRootViewProvider {
    val rootProvider: () -> View?

}