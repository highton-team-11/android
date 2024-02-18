package com.yongjincomapny.dreamcometrue.feature.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.databinding.ItemHomePostBinding
import com.yongjincomapny.dreamcometrue.feature.home.model.GetAllPostResponse

@Deprecated("end")
class HomePostAdapter(
    private val imageList: List<GetAllPostResponse>,
) : RecyclerView.Adapter<HomePostAdapter.HomePostViewHolder>() {
    inner class HomePostViewHolder(private val binding: ItemHomePostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GetAllPostResponse) {
            Log.d("banner recyclerview", "bind: $item")
            Glide.with(itemView)
                .load(item)
                .into(binding.ivPost)
            binding.tvTitle.text = item.title
            binding.root.setOnClickListener {
                val navController = Navigation.findNavController(itemView)
                navController.navigate(R.id.action_homeFragment_to_postDetailFragment, bundleOf("title" to item.title))
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HomePostViewHolder {
        return HomePostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home_banner_image,
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(holder: HomePostViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size
}