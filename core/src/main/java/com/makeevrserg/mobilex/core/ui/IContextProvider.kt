package com.makeevrserg.mobilex.core.ui

import android.content.Context

interface IContextProvider {
    val contextProvider: () -> Context?
}