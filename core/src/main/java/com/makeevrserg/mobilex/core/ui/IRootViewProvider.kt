package com.makeevrserg.mobilex.core.ui

import android.view.View

interface IRootViewProvider {
    val rootProvider: () -> View?

}