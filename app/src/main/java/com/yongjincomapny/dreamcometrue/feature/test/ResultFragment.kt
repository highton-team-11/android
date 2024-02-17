package com.yongjincomapny.dreamcometrue.feature.test

import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.databinding.FragmentResultBinding

class ResultFragment :BaseFragment<FragmentResultBinding> (
    R.layout.fragment_result
) {
    override fun init() {
        super.init()
        val strongList = arguments?.getStringArray("strongList")
        val interestList = arguments?.getStringArray("interestList")

        

    }
}