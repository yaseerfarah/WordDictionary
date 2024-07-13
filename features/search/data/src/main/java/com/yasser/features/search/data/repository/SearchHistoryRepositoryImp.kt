package com.yasser.features.search.data.repository


import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.yasser.common.data.datasource.local.LocalDataStore
import com.yasser.features.search.domain.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchHistoryRepositoryImp @Inject constructor(
    private val localDataStore: LocalDataStore
) : SearchHistoryRepository {

    private val wordsSearchKey = stringSetPreferencesKey("word_search")

    override fun getSearchHistory(): Flow<List<String>> {
       return localDataStore.readFromDataStoreAsFlow(wordsSearchKey, setOf()).map { it.toList() }
    }
}