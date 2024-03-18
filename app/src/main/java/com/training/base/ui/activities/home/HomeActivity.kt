package com.training.base.ui.activities.home
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.base.R
import com.training.base.data.objects.ServiceFunction
import com.training.base.databinding.ActivityHomeBinding
import com.training.base.ui.activities.task.demoLayout.DemoLayoutActivity
import com.training.base.ui.adapters.CommonAdapter
import com.training.base.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {
    override val model: HomeViewModel by viewModel()
    override val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    override val titleId: Int
        get() = R.string.app_name
    private var adapterServiceHome: CommonAdapter? = null
    override fun initView() {
        super.initView()
        setAdapterHomeService()
    }

    override fun onListener() {
        super.onListener()
        adapterServiceHome?.setOnClickItemListener {
            handleActionNext(it.getFunction() as ServiceFunction)
        }
    }

    private fun handleActionNext(function: ServiceFunction) {
        when (function) {
            ServiceFunction.LAYOUT -> {
                startActivity(Intent(this, DemoLayoutActivity::class.java))
            }
            else -> {
                confirm.newBuild().setNotice("Chức năng chưa phát triển từ từ học tới")
            }
        }
    }


    private fun setAdapterHomeService() {
        adapterServiceHome = CommonAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcvHomeServiceFunction.layoutManager = layoutManager
        binding.rcvHomeServiceFunction.adapter = adapterServiceHome
        adapterServiceHome?.updateData(model.getHomeServiceFunction())
    }
}