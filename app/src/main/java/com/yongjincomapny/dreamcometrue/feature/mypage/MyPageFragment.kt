package com.yongjincomapny.dreamcometrue.feature.mypage

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yongjincomapny.dreamcometrue.R
import com.yongjincomapny.dreamcometrue.common.base.BaseFragment
import com.yongjincomapny.dreamcometrue.common.view.setOnDebounceClickListener
import com.yongjincomapny.dreamcometrue.data.remote.api.JobApi
import com.yongjincomapny.dreamcometrue.data.remote.api.RetrofitClient
import com.yongjincomapny.dreamcometrue.data.remote.request.FetchRecommendJobsRequest
import com.yongjincomapny.dreamcometrue.data.remote.response.FetchRecommendJobsResponse
import com.yongjincomapny.dreamcometrue.databinding.FragmentMyPageBinding
import com.yongjincomapny.dreamcometrue.feature.result.adapter.ResultAdapter
import kotlinx.coroutines.launch
import java.util.UUID

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(
    R.layout.fragment_my_page,
) {
    private val jobApi: JobApi = RetrofitClient.getJobApi()

    override fun init() {
        super.init()

        val strongList = arguments?.getStringArray("strongList")?.toList() ?: emptyList()
        val interestList = arguments?.getStringArray("interestList")?.toList() ?: emptyList()

        val adapter = ResultAdapter("myPage")

        binding.rvMyPageCareer.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMyPageCareer.adapter = adapter

        binding.btnMyPageAddCareer.setOnDebounceClickListener {
            adapter.addData("메이크업아티스트")
        }

        lifecycleScope.launch {
            runCatching {
                jobApi.fetchRecommendJobs(
                    fetchRecommendJobsRequest = FetchRecommendJobsRequest(
                        strong = strongList,
                        interest = interestList,
                    )
                )
            }.onSuccess {
                adapter.setData(it)
            }.onFailure {

            }
        }
    }
}
