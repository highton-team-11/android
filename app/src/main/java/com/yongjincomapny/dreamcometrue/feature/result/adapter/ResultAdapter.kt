package com.yongjincomapny.dreamcometrue.feature.result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yongjincomapny.dreamcometrue.data.remote.response.FetchRecommendJobsResponse
import com.yongjincomapny.dreamcometrue.databinding.ItemJobBinding

class ResultAdapter() :
    ListAdapter<FetchRecommendJobsResponse, ResultAdapter.ResultItemViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultItemViewHolder {
        val binding = ItemJobBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ResultItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = currentList.size

    fun setData(data: List<FetchRecommendJobsResponse>) {
        submitList(data)
    }

    fun addData(data: List<FetchRecommendJobsResponse>) {
        val currentData = currentList.toMutableList()
        currentData.addAll(data)
        submitList(currentData)
    }

    /*fun clearData() {
        val currentData = currentList.toMutableList()
        currentData.clear()
        submitList(currentData)
    }*/

    companion object {
        private val diffUtil =
            object : DiffUtil.ItemCallback<FetchRecommendJobsResponse>() {
                override fun areItemsTheSame(
                    oldItem: FetchRecommendJobsResponse,
                    newItem: FetchRecommendJobsResponse
                ): Boolean {
                    return oldItem.uuid == newItem.uuid
                }

                override fun areContentsTheSame(
                    oldItem: FetchRecommendJobsResponse,
                    newItem: FetchRecommendJobsResponse
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    inner class ResultItemViewHolder(
        private val binding: ItemJobBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FetchRecommendJobsResponse) {
            binding.tvJobName.text = item.name
        }

    }
}