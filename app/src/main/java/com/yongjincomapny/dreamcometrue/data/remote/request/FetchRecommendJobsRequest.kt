package com.yongjincomapny.dreamcometrue.data.remote.request

import com.google.gson.annotations.SerializedName

data class FetchRecommendJobsRequest(
    @SerializedName("strong") val strong: List<String>,
    @SerializedName("interest") val interest: List<String>,
)
