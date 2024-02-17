package com.yongjincomapny.dreamcometrue.feature.home

import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.databinding.FragmentHomeBinding
import com.yongjincomapny.dreamcometrue.feature.home.adapter.DetailImageAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun init() {
        val imageAdapter = DetailImageAdapter(listOf(R.drawable.black_50_bg, R.drawable.ic_launcher_background)) {}
        binding.viewpager.adapter = imageAdapter
        super.init()
    }

    override fun observe() {
        super.observe()
    }
}