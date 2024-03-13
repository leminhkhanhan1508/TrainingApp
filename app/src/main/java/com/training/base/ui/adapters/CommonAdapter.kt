package com.training.base.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.base.data.objects.CommonEntity
import com.training.base.databinding.AdapterHeaderTypeBinding
import com.training.base.databinding.AdapterMainMenuServiceBinding
import com.training.base.extensions.setSafeOnClickListener

class CommonAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val MENU_SERVICE = 101
        const val HEADER = 100
    }

    var onClick: (CommonEntity) -> Unit = {}
    private val mDataSet = mutableListOf<CommonEntity>()

    fun setOnClickItemListener(onClick:(CommonEntity) -> Unit){
        this.onClick = onClick
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MENU_SERVICE -> {
                ServiceViewHolder(
                    AdapterMainMenuServiceBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            HEADER -> {
                HeaderViewHolder(
                    AdapterHeaderTypeBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            else -> {
                ServiceViewHolder(
                    AdapterMainMenuServiceBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = mDataSet[position]
        when (holder) {
            is HeaderViewHolder -> {
                holder.onBind(data)
            }
            is ServiceViewHolder -> {
                holder.onBind(data)
            }
        }

    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    override fun getItemViewType(position: Int): Int {
        val data = mDataSet[position]
        if (data.getTypeLayout() != 0) {
            return data.getTypeLayout()
        }
        return super.getItemViewType(position)
    }


    inner class ServiceViewHolder(private val binding: AdapterMainMenuServiceBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setSafeOnClickListener {
                val data = mDataSet[absoluteAdapterPosition]
                onClick.invoke(data)
            }
        }

        fun onBind(data: CommonEntity) {
            binding.txtFunctionName.text = data.getTitle()
            binding.txtFunctionDescription.text = data.getDescript()
        }
    }

    inner class HeaderViewHolder(private val binding: AdapterHeaderTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: CommonEntity) {
            binding.title.text = data.getTitle()
        }
    }
    fun updateData(list: List<CommonEntity>) {
        mDataSet.clear()
        mDataSet.addAll(list)
        notifyDataSetChanged()
    }
}