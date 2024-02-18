package com.yongjincomapny.dreamcometrue.feature.result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.data.remote.response.FetchRecommendJobsResponse
import com.yongjincomapny.dreamcometrue.databinding.ItemJobBinding
import java.util.UUID

class ResultAdapter(val fragment: String) :
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

    fun addData(name: String) {
        currentList.add(
            FetchRecommendJobsResponse(
                uuid = UUID.randomUUID(),
                name = name,
                description = "",
                salary = "",
                workAndLife = "",
                socialContribution = "",
                coreCompetencies = FetchRecommendJobsResponse.CoreCompetency(
                    id = UUID.randomUUID(),
                    name = "",
                    jobs = emptyList(),
                ),
            )
        )
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

            binding.root.setOnDebounceClickListener {
                val navController = Navigation.findNavController(itemView)
                navController.navigate(
                    when (fragment) {
                        "result" -> R.id.action_resultFragment_to_jobDetailsFragment
                        else -> R.id.action_myPageFragment_to_jobDetailFragment
                    },
                    bundleOf("name" to item.name)
                )
            }
        }
    }
}
