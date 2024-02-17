package com.yongjincomapny.dreamcometrue.data.remote.api

import com.yongjincomapny.dreamcometrue.data.remote.request.FetchRecommendJobsRequest
import com.yongjincomapny.dreamcometrue.data.remote.response.FetchRecommendJobsResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface JobApi {
    @POST("api/v1/job")
    suspend fun fetchRecommendJobs(
        @Body fetchRecommendJobsRequest: FetchRecommendJobsRequest,
    ): List<FetchRecommendJobsResponse>
}
