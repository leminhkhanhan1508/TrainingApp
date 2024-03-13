package com.training.base.di

import com.training.base.ui.activities.home.HomeViewModel
import com.training.base.ui.activities.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val models = module {
    viewModel {
        SplashViewModel(get(), get())
    }
    viewModel {
        HomeViewModel(get(), get())
    }
}


