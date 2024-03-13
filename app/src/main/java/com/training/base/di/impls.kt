package com.training.base.di

import com.training.base.data.impl.*
import org.koin.dsl.module

val impls = module {
    single<SplashRepo> {
        SplashRepoImpl(
            get()
        )
    }

    single<HomeRepo> {
        HomeRepoImpl(
            get()
        )
    }
}