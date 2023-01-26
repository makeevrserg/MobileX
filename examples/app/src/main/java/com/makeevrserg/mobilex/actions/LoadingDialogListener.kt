package com.makeevrserg.mobilex.actions

import android.app.Dialog
import com.makeevrserg.mobilex.ktx_core.action.IActionContainer
import kotlinx.coroutines.CoroutineScope

class LoadingDialogListener(
    override val lifecycleScope: CoroutineScope,
    override val androidViewProvider: AndroidViewProvider,
    dialog: () -> Dialog,
) : IActionCollector {
    private val dialog by lazy { dialog() }

    override fun collect(container: IActionContainer) =
        container.loadingFlow.collectOnMainLifecycleScope {
            if (it) dialog.show()
            else dialog.dismiss()
        }
}