package com.yongjincomapny.dreamcometrue.data.remote.api

import com.yongjincomapny.dreamcometrue.data.remote.response.FetchPostDetailResponse
import com.yongjincomapny.dreamcometrue.feature.home.model.GetAllPostResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("api/v1/export/find-all")
    suspend fun getAllPosts(): List<GetAllPostResponse>

    @GET("api/v1/export/{name}")
    suspend fun fetchPostDetail(
        @Path("name") name: String
    ): String
}


///api/v1/export/글제목
