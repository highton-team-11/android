package com.yongjincomapny.dreamcometrue.data.remote.response

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class FetchRecommendJobsResponse(
    @SerializedName("uuid") val uuid: UUID,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("salary") val salary: String,
    @SerializedName("workAndLife") val workAndLife: String,
    @SerializedName("socialContribution") val socialContribution: String,
    @SerializedName("coreCompetencies") val coreCompetencies: CoreCompetency,

    ) {
    data class CoreCompetency(
        @SerializedName("id") val id: UUID,
        @SerializedName("name") val name: String,
        @SerializedName("job") val jobs: List<String>,
    )
}
