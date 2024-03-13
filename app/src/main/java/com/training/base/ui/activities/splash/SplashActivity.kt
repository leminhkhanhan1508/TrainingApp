package com.training.base.ui.activities.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.training.base.databinding.ActivitySplashBinding
import com.training.base.ui.activities.home.HomeActivity
import com.training.base.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity:BaseActivity() {
    override val model: SplashViewModel by viewModel()
    override val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(Runnable {
            startActivity(Intent(this,
                HomeActivity::class.java))
            finish()
        }, 400)

    }
}