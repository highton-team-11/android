package com.yongjincomapny.dreamcometrue.data.remote.response

data class FetchJobDetailResponse(
    val coreCompetencies: CoreCompetencies,
    val description: String,
    val name: String,
    val salary: String,
    val socialContribution: String,
    val uuid: String,
    val workAndLife: String
) {
    data class CoreCompetencies(
        val id: String,
        val job: List<Any>,
        val name: String
    )
}