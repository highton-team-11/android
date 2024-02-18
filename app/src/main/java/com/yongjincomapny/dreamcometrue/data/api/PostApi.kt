package com.yongjincomapny.dreamcometrue.data.api

import com.yongjincomapny.dreamcometrue.feature.home.model.GetAllPostResponse
import retrofit2.http.GET

interface PostApi {
    @GET("api/v1/export/find-all")
    suspend fun getAllPosts(): List<GetAllPostResponse>


}


/api/v1/export/글제목
