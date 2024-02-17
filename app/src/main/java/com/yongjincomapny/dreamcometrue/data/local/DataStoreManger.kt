package com.yongjincomapny.dreamcometrue.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


object DataStoreManger {
    private val Context.datastore: DataStore<Preferences> by preferencesDataStore(Keys.DATASTORE_NAME)

    suspend fun setValue(
        context: Context,
        key: String,
        value: String,
    ) {
        context.datastore.edit { datastore ->
            datastore[stringPreferencesKey(key)] = value
        }
    }

    fun getValue(
        context: Context,
        key: String,
    ): Flow<String?> {
        return context.datastore.data.map { datastore ->
            datastore[stringPreferencesKey(key)]
        }
    }
}
