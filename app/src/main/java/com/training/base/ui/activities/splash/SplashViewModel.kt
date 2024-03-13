package com.training.base.ui.activities.splash

import com.training.base.data.impl.SplashRepo
import com.training.base.di.ResourceProvider
import com.training.base.ui.base.BaseViewModel

class SplashViewModel(
    private val splashRepo: SplashRepo,
    val resourcesProvider: ResourceProvider
) : BaseViewModel() {


}