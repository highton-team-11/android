package com.yongjincomapny.dreamcometrue.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.databinding.ItemHomeImageDetailBinding

class DetailImageAdapter(
    private val imageList: List<Int?>,
    private val itemClick: (Int) -> Unit,
) : RecyclerView.Adapter<DetailImageAdapter.ImageDetailViewHolder>() {
    inner class ImageDetailViewHolder(private val binding: ItemHomeImageDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int?) {
            Glide.with(binding.root.context)
                .load(R.drawable.ic_launcher_background)
                .into(binding.imgUrl)

            binding.root.setOnClickListener { itemClick(item!!) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ImageDetailViewHolder {
        return ImageDetailViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home_image_detail,
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