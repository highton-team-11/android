package com.yongjincomapny.dreamcometrue.feature.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjincomapny.dreamcometrue.data.repository.Repository
import kotlinx.coroutines.launch

class FirstSurveyViewModel(val repository: Repository): ViewModel() {

    fun saveName(name: String) {
        viewModelScope.launch {
            runCatching {
                repository.putName(name)
            }.onSuccess {
                println("저장성공")
            }.onFailure {
                println("다시 시도해주세요")
            }
        }
    }
}