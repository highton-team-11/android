package com.yongjincomapny.dreamcometrue.feature.job

import android.util.Log
import androidx.core.text.HtmlCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.data.remote.api.RetrofitClient
import com.yongjincomapny.dreamcometrue.databinding.FragmentJobDetailsBinding
import kotlinx.coroutines.launch
import java.text.DecimalFormat

class JobDetailsFragment : BaseFragment<FragmentJobDetailsBinding>(
    R.layout.fragment_job_details,
) {
    override fun init() {
        super.init()
        val name = arguments?.getString("name") ?: ""

        val jobApi = RetrofitClient.getJobApi()

        binding.ivJobDetailsBack.setOnDebounceClickListener {
            findNavController().popBackStack()
        }

        lifecycleScope.launch {
            runCatching {
                jobApi.fetchRoadMap(name)
            }.onSuccess {

                binding.tvRoadmap.text = HtmlCompat.fromHtml(
                    it.choices.first().message.content,
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }
        }

        lifecycleScope.launch {
            runCatching {
                jobApi.fetchJobDetail(name)
            }.onSuccess {
                with(binding) {
                    val salary = Integer.parseInt(it.salary.first().toString())
                        .toFloat() * 1000f
                    val decimalFormat = DecimalFormat("#,###")

                    tvJobDetailsTitle.text = it.name
                    tvJotDetailsDescription.text = it.description
                    tvAverageNewcomer.text = decimalFormat.format(salary * (2.0 / 3.0))
                    tvAverageJob.text = decimalFormat.format(salary)

                    tvWorkLifeBalance.text = it.workAndLife
                    tvSocialContribution.text = it.socialContribution

                    progressWorkLifeBalance.progress = when (it.workAndLife) {
                        "보통미만" -> 40
                        "보통이상" -> 60
                        "좋음" -> 80
                        "매우좋음" -> 100
                        else -> 0
                    }

                    progressSocialContribution.progress = when (it.socialContribution) {
                        "보통미만" -> 40
                        "보통이상" -> 60
                        "좋음" -> 80
                        "매우좋음" -> 100
                        else -> 0
                    }
                }
            }.onFailure {
                Log.d("TEST", it.toString())
            }
        }
    }
}
