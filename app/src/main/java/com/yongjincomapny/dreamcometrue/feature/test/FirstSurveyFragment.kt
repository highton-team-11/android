package com.yongjincomapny.dreamcometrue.feature.test

import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.findNavController
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.databinding.FragmentFirstSurveyBinding

class FirstSurveyFragment : BaseFragment<FragmentFirstSurveyBinding>(
    R.layout.fragment_first_survey
) {
    override fun init() {
        super.init()

        binding.btnNext.setOnDebounceClickListener {
            if (binding.etName.text.toString().isNotBlank()) {
                findNavController().navigate(R.id.action_firstSurveyFragment_to_secondSurveyFragment)
            }
        }

    }
}