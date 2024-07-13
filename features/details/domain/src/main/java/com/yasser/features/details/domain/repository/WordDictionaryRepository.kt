package com.yasser.features.details.domain.repository

import com.yasser.common.domain.entity.network.ResponseStatus
import com.yasser.features.details.domain.entity.WordInfoEntity
import kotlinx.coroutines.flow.Flow

interface WordDictionaryRepository {

    suspend fun getWordInfo(word: String): Flow<ResponseStatus<List<WordInfoEntity>>>


}