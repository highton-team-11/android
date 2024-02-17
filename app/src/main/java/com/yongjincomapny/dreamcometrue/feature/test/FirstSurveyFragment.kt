package com.yongjincomapny.dreamcometrue.feature.test

import androidx.navigation.fragment.findNavController
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.databinding.FragmentFirstSurveyBinding

class FirstSurveyFragment : BaseFragment<FragmentFirstSurveyBinding>(
    R.layout.fragment_first_survey
) {
    override fun observe() {
        super.observe()

    }

    override fun init() {
        super.init()

        binding.btnNext.setOnDebounceClickListener {
            if (binding.etName.text.toString().isNotBlank()) {
                //TODO: local에 이름 저장하는 로직 작성 필요.
                //TODO : 저장 후, Navigate next survey화면
                findNavController().navigate(R.id.action_firstSurveyFragment_to_secondSurveyFragment)
            }
        }

    }
}