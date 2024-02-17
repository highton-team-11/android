package com.yongjincomapny.dreamcometrue.feature.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.databinding.ItemStrongPointBinding

class StrongPointAdapter(
    private val items: List<StrongPointItem>,
    private val itemSelectedListener: OnItemSelectedListener
) :
    RecyclerView.Adapter<StrongPointAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStrongPointBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemStrongPointBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: StrongPointItem) {
            binding.tvItem.text = item.text

            binding.clItem.setOnClickListener {
                item.isSelected = !item.isSelected
                if (item.isSelected) {
                    binding.clItem.setBackgroundResource(R.drawable.primary10_50_1_bg)
                } else {
                    binding.clItem.setBackgroundResource(R.drawable.white_50_1_bg)
                }

            }
            binding.executePendingBindings()
        }
    }
}


interface OnItemSelectedListener {
    fun onItemSelected(item: StrongPointItem)
}