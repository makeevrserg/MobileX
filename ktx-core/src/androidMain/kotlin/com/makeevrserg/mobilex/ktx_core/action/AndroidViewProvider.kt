package com.makeevrserg.mobilex.ktx_core.action

import android.content.Context
import android.view.View

interface AndroidViewProvider{
    fun getViewContext(): Context?
    fun getRootView(): View?
}