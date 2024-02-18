package com.yongjincomapny.dreamcometrue.data.remote.api

import com.yongjincomapny.dreamcometrue.data.remote.request.FetchRecommendJobsRequest
import com.yongjincomapny.dreamcometrue.data.remote.response.FetchJobDetailResponse
import com.yongjincomapny.dreamcometrue.data.remote.response.FetchRecommendJobsResponse
import com.yongjincomapny.dreamcometrue.data.remote.response.FetchRoadMapResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface JobApi {
    @POST("api/v1/job")
    suspend fun fetchRecommendJobs(
        @Body fetchRecommendJobsRequest: FetchRecommendJobsRequest,
    ): List<FetchRecommendJobsResponse>

    @GET("/api/v1/job/{name}")
    suspend fun fetchJobDetail(
        @Path("name") name: String
    ): FetchJobDetailResponse

    @POST("/api/{name}")
    suspend fun fetchRoadMap(
        @Path("name") name: String,
    ): FetchRoadMapResponse
}
