package com.yongjincomapny.dreamcometrue.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.databinding.ItemHomePostBinding
import com.yongjincomapny.dreamcometrue.feature.home.model.GetAllPostResponse

class NewHomePostTwoAdapter() :
    ListAdapter<GetAllPostResponse, NewHomePostTwoAdapter.ResultItemViewHolder>(diffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultItemViewHolder {
        val binding = ItemHomePostBinding.inflate(
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

    fun setData(data: List<GetAllPostResponse>) {
        submitList(data)
    }


    companion object {
        private val diffUtil =
            object : DiffUtil.ItemCallback<GetAllPostResponse>() {
                override fun areItemsTheSame(
                    oldItem: GetAllPostResponse,
                    newItem: GetAllPostResponse
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: GetAllPostResponse,
                    newItem: GetAllPostResponse
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    inner class ResultItemViewHolder(
        private val binding: ItemHomePostBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: GetAllPostResponse) {
           Glide.with(binding.root.context)
                .load(item.cdnLink.toUri())
                .into(binding.ivPost)

                binding.tvTitle.text = item.title

            binding.root.setOnClickListener {
                val navController = Navigation.findNavController(itemView)
                navController.navigate(R.id.action_homeFragment_to_postDetailFragment, bundleOf("title" to item.title))
            }
        }

    }
}