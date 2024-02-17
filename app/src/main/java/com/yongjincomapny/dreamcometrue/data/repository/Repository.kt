package com.yongjincomapny.dreamcometrue.data.repository

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun putName(name: String)
    suspend fun putStrength(strength: String)
    suspend fun putField(field: String)

    fun getName(defaultValue: String = ""): Flow<String>
    fun getStrength(defaultValue: String = ""): Flow<String>
    fun getField(defaultValue: String = ""): Flow<String>
}
