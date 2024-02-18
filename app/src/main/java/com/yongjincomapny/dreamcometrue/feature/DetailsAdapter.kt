package com.yongjincomapny.dreamcometrue.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.yongjincomapny.dreamcometrue.databinding.ItemJobDetailsRoadMapBinding

class DetailsAdapter(val list: List<String>) :
    RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {
    class DetailsViewHolder(
        private val binding: ItemJobDetailsRoadMapBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: String,
            position: Int,
        ) {
            binding.tvRoadMapStep.text = item
            if (position == 0) {
                binding.dividerRoadMap1.isInvisible = true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val binding = ItemJobDetailsRoadMapBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DetailsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
}
