package com.yongjincomapny.dreamcometrue.feature.home

import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.databinding.FragmentHomeBinding
import com.yongjincomapny.dreamcometrue.feature.home.adapter.DetailImageAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun init() {
        val imageAdapter = DetailImageAdapter(listOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3)) {}
        binding.viewpager.adapter = imageAdapter
        binding.wormDotsIndicator.attachTo(binding.viewpager)
        super.init()
    }

    override fun observe() {
        super.observe()
    }
}