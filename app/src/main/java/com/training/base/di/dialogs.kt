package com.training.base.di

import com.training.base.ui.dialogs.LoadingDialog
import com.training.base.ui.dialogs.ConfirmDialog
import org.koin.dsl.module

val dialogs = module {
    factory { createLoadingDialog() }
    factory { createConfirmDialog() }
}

fun createLoadingDialog(): LoadingDialog {
    return LoadingDialog(Common.currentActivity)
}

fun createConfirmDialog(): ConfirmDialog {
    return ConfirmDialog(Common.currentActivity)
}
