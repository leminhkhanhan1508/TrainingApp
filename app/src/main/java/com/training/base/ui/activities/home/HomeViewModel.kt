package com.training.base.ui.activities.home

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.MutableLiveData
import com.training.base.R
import com.training.base.data.impl.HomeRepo
import com.training.base.data.objects.CommonEntity
import com.training.base.data.objects.ServiceFunction
import com.training.base.data.response.LoginResponse
import com.training.base.di.ResourceProvider
import com.training.base.ui.adapters.CommonAdapter
import com.training.base.ui.base.BaseViewModel

class HomeViewModel(
    private val homeRepo: HomeRepo,
    val resourcesProvider: ResourceProvider
) : BaseViewModel() {
    val loginResponse = MutableLiveData<LoginResponse>()
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
    fun login(userName: String, password: String) =
        launch {
            val login = homeRepo.login(userName, password)
            loginResponse.postValue(login)
        }


    fun getuser() =
        launch {
            val response = homeRepo.getUsers()
        }

    fun getHomeServiceFunction(): MutableList<CommonEntity> {
        return mutableListOf(
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.title_training_recyclerview))
                this.setDescript(resourcesProvider.getString(R.string.description_training_recyclerview))
                this.setFunction(ServiceFunction.RECYCLERVIEW)
                this.setTypeLayout(CommonAdapter.MENU_SERVICE)
            },
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.title_training_recyclerview))
                this.setDescript(resourcesProvider.getString(R.string.description_training_recyclerview))
                this.setFunction(ServiceFunction.RECYCLERVIEW)
                this.setTypeLayout(CommonAdapter.MENU_SERVICE)
            },
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.title_training_recyclerview))
                this.setDescript(resourcesProvider.getString(R.string.description_training_recyclerview))
                this.setFunction(ServiceFunction.RECYCLERVIEW)
                this.setTypeLayout(CommonAdapter.MENU_SERVICE)
            },
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.title_training_recyclerview))
                this.setDescript(resourcesProvider.getString(R.string.description_training_recyclerview))
                this.setFunction(ServiceFunction.RECYCLERVIEW)
                this.setTypeLayout(CommonAdapter.MENU_SERVICE)
            },
        )
    }

    fun getHomeBottomBarFunction(): MutableList<CommonEntity> {
        return mutableListOf(
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.home_page))
                this.setDescript(resourcesProvider.getString(R.string.splash_hello))
                this.setIcon(R.drawable.baseline_home_24)
            },
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.setting_page))
                this.setDescript(resourcesProvider.getString(R.string.splash_hello))
                this.setIcon(R.drawable.baseline_settings_suggest_24)
            },
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.other_page))
                this.setDescript(resourcesProvider.getString(R.string.splash_hello))
                this.setIcon(R.drawable.baseline_scatter_plot_24)
            }
        )
    }
}