package com.yongjincomapny.dreamcometrue.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    private var retrofit: Retrofit = Retrofit.Builder().baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}
