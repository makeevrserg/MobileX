package com.makeevrserg.mvvmcore.core.ui

import android.content.Context

interface IContextProvider {
    val contextProvider: () -> Context?

}