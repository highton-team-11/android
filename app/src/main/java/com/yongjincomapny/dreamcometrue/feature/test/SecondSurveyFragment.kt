package com.yongjincomapny.dreamcometrue.feature.test

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.GridSpacingItemDecoration
import com.yongjincomapny.dreamcometrue.common.view.fromDpToPx
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.databinding.FragmentSecondSurveyBinding
import com.yongjincomapny.dreamcometrue.feature.test.adapter.strongpoint.OnItemSelectedListener
import com.yongjincomapny.dreamcometrue.feature.test.adapter.strongpoint.StrongPointAdapter
import com.yongjincomapny.dreamcometrue.feature.test.adapter.strongpoint.StrongPointItem

class SecondSurveyFragment : BaseFragment<FragmentSecondSurveyBinding>(
    R.layout.fragment_second_survey
), OnItemSelectedListener {
    override fun init() {
        super.init()

        binding.ivBack.setOnDebounceClickListener {
            findNavController().popBackStack()
        }

        val recyclerView: RecyclerView = binding.rvStrongPoint
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        val items = listOf(
            StrongPointItem("신체 & 운동"),
            StrongPointItem("손재주"),
            StrongPointItem("음악"),
            StrongPointItem("수리 & 논리력"),
            StrongPointItem("자기성찰"),
            StrongPointItem("대인관계 "),
            StrongPointItem("자연 친화력"),
            StrongPointItem("예술 시각")
        )

        val adapter = StrongPointAdapter(items, this)
        recyclerView.adapter = adapter

        binding.rvStrongPoint.addItemDecoration(
            GridSpacingItemDecoration(spanCount = 2, spacing = 16f.fromDpToPx())
        )

        binding.btnNext.setOnDebounceClickListener {
            findNavController().navigate(R.id.action_secondSurveyFragment_to_thirdSurveyFragment)
        }
    }

    override fun onItemSelected(item: StrongPointItem) {

    }
}
