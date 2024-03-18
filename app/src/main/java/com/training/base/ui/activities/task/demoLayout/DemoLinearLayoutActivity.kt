package com.training.base.ui.activities.task.demoLayout
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.base.R
import com.training.base.data.objects.LayoutType
import com.training.base.databinding.ActivityDemoLayoutBinding
import com.training.base.databinding.ActivityDemoLinearlayoutBinding
import com.training.base.ui.adapters.CommonAdapter
import com.training.base.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class DemoLinearLayoutActivity : BaseActivity() {
    override val model: DemoLinearLayoutViewModel by viewModel()
    override val binding by lazy {
        ActivityDemoLinearlayoutBinding.inflate(layoutInflater)
    }
    override val titleId: Int
        get() = R.string.title_training_linearlayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}