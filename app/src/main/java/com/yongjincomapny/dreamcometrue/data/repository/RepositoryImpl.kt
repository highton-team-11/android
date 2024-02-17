package com.yongjincomapny.dreamcometrue.data.repository

import android.content.Context
import com.yongjincomapny.dreamcometrue.data.local.DataStoreManger
import com.yongjincomapny.dreamcometrue.data.local.Keys
import kotlinx.coroutines.flow.map

class RepositoryImpl(
    private val context: Context,
    private val dataStoreManager: DataStoreManger = DataStoreManger,
) : Repository {
    override suspend fun putName(name: String) {
        dataStoreManager.setValue(
            context = context,
            key = Keys.NAME,
            value = name,
        )
    }

    override suspend fun putStrength(strength: String) {
        dataStoreManager.setValue(
            context = context,
            key = Keys.STRENGTH,
            value = strength,
        )
    }

    override suspend fun putField(field: String) {
        dataStoreManager.setValue(
            context = context,
            key = Keys.FIELD,
            value = field,
        )
    }

    override fun getName(defaultValue: String) = dataStoreManager.getValue(
        context = context,
        key = Keys.NAME,
    ).map { it ?: defaultValue }

    override fun getStrength(defaultValue: String) = dataStoreManager.getValue(
        context = context,
        key = Keys.STRENGTH,
    ).map { it ?: defaultValue }


    override fun getField(defaultValue: String) = dataStoreManager.getValue(
        context = context,
        key = Keys.FIELD,
    ).map { it ?: defaultValue }
}
