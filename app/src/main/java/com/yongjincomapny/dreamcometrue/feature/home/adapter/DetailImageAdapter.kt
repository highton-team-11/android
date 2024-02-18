package com.yongjincomapny.dreamcometrue.feature.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.databinding.ItemHomeBannerImageBinding

class DetailImageAdapter(
    private val imageList: List<Int>,
    private val itemClick: (Int) -> Unit,
) : RecyclerView.Adapter<DetailImageAdapter.ImageDetailViewHolder>() {
    inner class ImageDetailViewHolder(private val binding: ItemHomeBannerImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int) {
            Glide.with(itemView.context)
                .load(item)
                .into(binding.imgUrl)

            binding.root.setOnClickListener { itemClick(item) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ImageDetailViewHolder {
        return ImageDetailViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home_banner_image,
                parent,
                false,
            ),
        )
    }

    override fun onBindViewHolder(
        holder: ImageDetailViewHolder,
        position: Int,
    ) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size
}
