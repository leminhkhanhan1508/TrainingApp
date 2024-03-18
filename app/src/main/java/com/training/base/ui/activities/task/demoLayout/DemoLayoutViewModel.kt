package com.training.base.ui.activities.task.demoLayout

import com.training.base.R
import com.training.base.data.objects.CommonEntity
import com.training.base.data.objects.LayoutType
import com.training.base.di.ResourceProvider
import com.training.base.ui.adapters.CommonAdapter
import com.training.base.ui.base.BaseViewModel

class DemoLayoutViewModel(
    val resourcesProvider: ResourceProvider
) : BaseViewModel() {

    fun getKindOfLayout(): MutableList<CommonEntity> {
        return mutableListOf(
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.title_training_linearlayout))
                this.setDescript(resourcesProvider.getString(R.string.description_training_linearlayout))
                this.setFunction(LayoutType.LINEARLAYOUT)
                this.setTypeLayout(CommonAdapter.MENU_SERVICE)
            },
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.title_training_ralativelayout))
                this.setDescript(resourcesProvider.getString(R.string.description_training_ralativelayout))
                this.setFunction(LayoutType.RELATIVELAYOUT)
                this.setTypeLayout(CommonAdapter.MENU_SERVICE)
            },
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.title_training_constrainlayout))
                this.setDescript(resourcesProvider.getString(R.string.description_training_constrainlayout))
                this.setFunction(LayoutType.CONSTRAINLAYOUT)
                this.setTypeLayout(CommonAdapter.MENU_SERVICE)
            },
            CommonEntity().apply {
                this.setTitle(resourcesProvider.getString(R.string.title_training_framelayout))
                this.setDescript(resourcesProvider.getString(R.string.description_training_framelayout))
                this.setFunction(LayoutType.FRAMELAYOUT)
                this.setTypeLayout(CommonAdapter.MENU_SERVICE)
            },
        )
    }

}