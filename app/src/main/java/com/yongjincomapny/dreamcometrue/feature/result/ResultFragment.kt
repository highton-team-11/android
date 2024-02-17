package com.yongjincomapny.dreamcometrue.feature.result

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.data.remote.api.RetrofitClient
import com.yongjincomapny.dreamcometrue.data.remote.request.FetchRecommendJobsRequest
import com.yongjincomapny.dreamcometrue.databinding.FragmentResultBinding
import com.yongjincomapny.dreamcometrue.feature.result.adapter.ResultAdapter
import com.yongjincomapny.dreamcometrue.feature.test.adapter.strongpoint.StrongPointAdapter
import com.yongjincomapny.dreamcometrue.feature.test.adapter.strongpoint.StrongPointItem
import kotlinx.coroutines.Dispatchers
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


        lifecycleScope.launch() {
            runCatching {
                jobApi.fetchRecommendJobs(
                    FetchRecommendJobsRequest(
                        strongList!!.toList(), interestList!!.toList()
                    )
                )
            }.onSuccess {
                binding.tvMostFitJob.text = it.first().name
                var otherRecommendJobs = it.drop(1)
                resultAdapter?.setData(otherRecommendJobs)
            }
        }
    }
}