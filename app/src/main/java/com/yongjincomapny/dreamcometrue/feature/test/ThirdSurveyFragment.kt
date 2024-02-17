package com.yongjincomapny.dreamcometrue.feature.test

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.GridSpacingItemDecoration
import com.yongjincomapny.dreamcometrue.common.view.fromDpToPx
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.databinding.FragmentThirdSurveyBinding
import com.yongjincomapny.dreamcometrue.feature.test.adapter.category.FirstCategoryAdapter
import com.yongjincomapny.dreamcometrue.feature.test.adapter.category.CategoryItem
import com.yongjincomapny.dreamcometrue.feature.test.adapter.category.OnItemSelectedListener

class ThirdSurveyFragment : BaseFragment<FragmentThirdSurveyBinding>(
    R.layout.fragment_third_survey
), OnItemSelectedListener{
    override fun init() {
        super.init()

        binding.ivBack.setOnDebounceClickListener {
            findNavController().popBackStack()
        }

        val firstItems = listOf(
            CategoryItem("운동"),
            CategoryItem("무용"),
            CategoryItem("안전"),
            CategoryItem("운전"),
            CategoryItem("기능직"),
        )

        val secondItems = listOf(
            CategoryItem("의복제조"),
            CategoryItem("조리"),
            CategoryItem("공학"),
            CategoryItem("의료"),
            CategoryItem("IT"),
            CategoryItem("보건의료"),
        )

        val thirdItems = listOf(
            CategoryItem("음악"),
            CategoryItem("악기"),
            CategoryItem("연기"),
            CategoryItem("미술 및 공예"),
            CategoryItem("웹·게임·애니메이션"),
            CategoryItem("디자인"),
            CategoryItem("영상"),
            CategoryItem("예술기획"),
            CategoryItem("기타 특수 예술"),
        )

        val fourthItems = listOf(
            CategoryItem("금융 및 경영"),
            CategoryItem("회계"),
            CategoryItem("기획"),
            CategoryItem("매니지먼트"),
            CategoryItem("사무"),
            CategoryItem("일반 서비스직"),
            CategoryItem("사회서비스"),
        )

        val fifthItems = listOf(
            CategoryItem("인문계 교육"),
            CategoryItem("이공계 교육"),
            CategoryItem("언어"),
            CategoryItem("작가"),
            CategoryItem("교육 관련 서비스"),
            CategoryItem("인문 및 사회과학"),
        )

        val sixthItems = listOf(
            CategoryItem("자연친화"),
            CategoryItem("농생명산업"),
            CategoryItem("환경관련"),
            CategoryItem("법률 및 사회활동"),
            CategoryItem("이학"),
        )

        binding.rvFirstCategory.layoutManager = GridLayoutManager(requireContext(),4)
        binding.rvFirstCategory.adapter = FirstCategoryAdapter(firstItems, this)
        binding.rvFirstCategory.addItemDecoration(
            GridSpacingItemDecoration(spanCount = 4, spacing = 8f.fromDpToPx())
        )
        binding.rvSecondCategory.layoutManager = GridLayoutManager(requireContext(),4)
        binding.rvSecondCategory.adapter = FirstCategoryAdapter(secondItems, this)
        binding.rvSecondCategory.addItemDecoration(
            GridSpacingItemDecoration(spanCount = 4, spacing =8f.fromDpToPx())
        )

        binding.rvThirdCategory.layoutManager = GridLayoutManager(requireContext(),3)
        binding.rvThirdCategory.adapter = FirstCategoryAdapter(thirdItems, this)
        binding.rvThirdCategory.addItemDecoration(
            GridSpacingItemDecoration(spanCount = 3, spacing = 8f.fromDpToPx())
        )
        binding.rvFourthCategory.layoutManager = GridLayoutManager(requireContext(),3)
        binding.rvFourthCategory.adapter = FirstCategoryAdapter(fourthItems, this)
        binding.rvFourthCategory.addItemDecoration(
            GridSpacingItemDecoration(spanCount = 3, spacing = 8f.fromDpToPx())
        )
        binding.rvFifthCategory.layoutManager = GridLayoutManager(requireContext(),3)
        binding.rvFifthCategory.adapter = FirstCategoryAdapter(fifthItems, this)
        binding.rvFifthCategory.addItemDecoration(
            GridSpacingItemDecoration(spanCount = 3, spacing = 8f.fromDpToPx())
        )
        binding.rvSixthCategory.layoutManager = GridLayoutManager(requireContext(),3)
        binding.rvSixthCategory.adapter = FirstCategoryAdapter(sixthItems, this)
        binding.rvSixthCategory.addItemDecoration(
            GridSpacingItemDecoration(spanCount = 3, spacing = 8f.fromDpToPx())
        )

    }

    override fun onFirstCategoryItemSelected(item: CategoryItem) {

    }

    override fun onSecondCategoryItemSelected(item: CategoryItem) {
        TODO("Not yet implemented")
    }

    override fun onThirdCategoryItemSelected(item: CategoryItem) {
        TODO("Not yet implemented")
    }

    override fun onFourthCategoryItemSelected(item: CategoryItem) {
        TODO("Not yet implemented")
    }

    override fun onFifthCategoryItemSelected(item: CategoryItem) {
        TODO("Not yet implemented")
    }

    override fun onSixthCategoryItemSelected(item: CategoryItem) {
        TODO("Not yet implemented")
    }
}