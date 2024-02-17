package com.yongjincomapny.dreamcometrue.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincomapny.dreamcometrue.data.api.RetrofitClient
import com.yongjincomapny.dreamcometrue.feature.home.model.GetAllPostResponse
import kotlinx.coroutines.launch

class HomeViewModel:ViewModel() {
    val postList = MutableLiveData<List<GetAllPostResponse>>()
    fun getPostList() {
        viewModelScope.launch {
            runCatching {
                RetrofitClient.postApi().getAllPosts()
            }.onSuccess {
                postList.value = it
            }.onFailure {
                println("다시 시도해주세요")
            }
        }
    }
}
