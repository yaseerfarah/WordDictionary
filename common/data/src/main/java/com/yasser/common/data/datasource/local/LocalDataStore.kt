package com.yasser.common.data.datasource.local

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore by preferencesDataStore("worddictionary")

class LocalDataStore @Inject constructor(
    @ApplicationContext private val appContext: Context
) {
    suspend fun<T> writeToDataStore(key: Preferences.Key<T>,value: T) {
        appContext.dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun<T> readFromDataStore(key: Preferences.Key<T>): T? {
        val preferences = appContext.dataStore.data.first()
        return preferences[key]
    }

    suspend fun<T> readFromDataStore(key: Preferences.Key<T>,defaultValue: T): T {
        val preferences = appContext.dataStore.data.first()
        return preferences[key]?:defaultValue
    }

     fun<T> readFromDataStoreAsFlow(key: Preferences.Key<T>): Flow<T?> {
        return appContext.dataStore.data.map { preferences->
            preferences[key]
        }
    }

    fun<T> readFromDataStoreAsFlow(key: Preferences.Key<T>,defaultValue: T): Flow<T> {
        return appContext.dataStore.data.map { preferences->
            preferences[key]?:defaultValue
        }
    }
}