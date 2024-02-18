package com.yongjincomapny.dreamcometrue.feature.result

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.data.remote.api.RetrofitClient
import com.yongjincomapny.dreamcometrue.data.remote.request.FetchRecommendJobsRequest
import com.yongjincomapny.dreamcometrue.databinding.FragmentResultBinding
import com.yongjincomapny.dreamcometrue.feature.result.adapter.ResultAdapter
import kotlinx.coroutines.launch

class ResultFragment : BaseFragment<FragmentResultBinding>(
    R.layout.fragment_result
) {
    private var resultAdapter: ResultAdapter? = null
    override fun init() {
        super.init()
        val strongList = arguments?.getStringArray("strongList")
        val interestList = arguments?.getStringArray("interestList")

        val jobApi = RetrofitClient.getJobApi()

        binding.rvJob.layoutManager = LinearLayoutManager(requireContext())
        resultAdapter = ResultAdapter()
        binding.rvJob.adapter = resultAdapter

        binding.btnNext.setOnDebounceClickListener {
            //TODO: Home으로 navigate하는 코드.
        }

        lifecycleScope.launch() {
            if (strongList != null) {
                if (interestList != null) {
                    runCatching {
                        jobApi.fetchRecommendJobs(
                            FetchRecommendJobsRequest(
                                strongList.toList(), interestList.toList()
                            )
                        )
                    }.onSuccess {
                        binding.tvMostFitJob.text = it.first().name
                        var otherRecommendJobs = it.drop(1)
                        resultAdapter?.setData(otherRecommendJobs)
                    }.onFailure {
                        Toast.makeText(requireContext(), "다시 시도해주세요!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
