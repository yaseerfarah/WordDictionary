package com.yasser.features.search.domain.repository

import kotlinx.coroutines.flow.Flow

interface SearchHistoryRepository {

    fun getSearchHistory(): Flow<List<String>>

}