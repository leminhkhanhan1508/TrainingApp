package com.training.base.ui.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.training.base.R
import com.training.base.di.Common
import com.training.base.extensions.setSafeOnClickListener
import com.training.base.ui.dialogs.LoadingDialog
import com.training.base.ui.dialogs.ConfirmDialog
import java.util.*

abstract class BaseActivity : AppCompatActivity() {
    val loading by lazy { LoadingDialog(this) }
    val confirm by lazy { ConfirmDialog(this) }

    abstract val model: BaseViewModel
    protected abstract val binding: ViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen(R.color.color_00a1e4)
        Common.currentActivity = this
        setContentView(binding.root)
        setTitle(R.string.app_name)
        initView()
        onListener()
        onObserveData()
    }
    override fun setTitle(titleId: Int) {
        binding.root.findViewById<TextView>(R.id.txtTitle)?.text = getString(titleId)
    }
    open fun initView() {}

    open fun onListener() {
        binding.root.findViewById<ImageView>(R.id.icBack)?.setSafeOnClickListener {
            onBackPressed()
        }
    }

    open fun onObserveData() {
       model.apply {
           isLoading.observe(this@BaseActivity, Observer {
               handleShowLoading(it)
           })
           noInternetConnectionEvent.observe(this@BaseActivity, Observer {
               confirm.newBuild().setNotice(R.string.error_no_network)
           })
           connectTimeoutEvent.observe(this@BaseActivity, Observer {
               confirm.newBuild().setNotice(R.string.error_network_disconnect)
           })
           invalidCertificateEvent.observe(this@BaseActivity, Observer {
               confirm.newBuild().setNotice(R.string.error_cerpinning)
           })
       }
    }

    override fun onStop() {
        super.onStop()
        if (loading.isShowing) {
            loading.cancel()
        }
    }
    fun hideLoading() {
        loading.dismiss()
    }

    fun showLoading() {
        loading.show()
    }
    open fun handleShowLoading(isLoading: Boolean) {
        runOnUiThread {
            if (isLoading) showLoading() else hideLoading()
        }
    }

    open fun setFullScreen(colorStatusBar: Int) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ActivityCompat.getColor(this, colorStatusBar)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
}