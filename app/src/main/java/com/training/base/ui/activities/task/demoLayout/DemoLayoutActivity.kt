package com.training.base.ui.activities.task.demoLayout
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.base.R
import com.training.base.data.objects.LayoutType
import com.training.base.databinding.ActivityDemoLayoutBinding
import com.training.base.ui.adapters.CommonAdapter
import com.training.base.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class DemoLayoutActivity : BaseActivity() {
    override val model: DemoLayoutViewModel by viewModel()
    override val binding by lazy {
        ActivityDemoLayoutBinding.inflate(layoutInflater)
    }
    override val titleId: Int
        get() = R.string.title_training_layout
    private var adapterLayout: CommonAdapter? = null


    override fun initView() {
        super.initView()
        setAdapterHomeService()
    }

    override fun onListener() {
        super.onListener()
        adapterLayout?.setOnClickItemListener {
            handleActionNext(it.getFunction() as LayoutType)
        }
    }

    private fun handleActionNext(function: LayoutType) {
        when (function) {
            LayoutType.LINEARLAYOUT -> {
                startActivity(Intent(this, DemoLinearLayoutActivity::class.java))
            }
            else -> {
                confirm.newBuild().setNotice("Chức năng chưa phát triển từ từ học tới")
            }
        }
    }

    private fun setAdapterHomeService() {
        adapterLayout = CommonAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcvLayoutType.layoutManager = layoutManager
        binding.rcvLayoutType.adapter = adapterLayout
        adapterLayout?.updateData(model.getKindOfLayout())
    }
}