package com.yasser.features.details.data.repository


import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.yasser.common.data.datasource.local.LocalDataStore
import com.yasser.common.data.extensions.safeApiCall
import com.yasser.common.domain.entity.network.ResponseStatus
import com.yasser.features.details.data.datasource.local.WordInfoDao
import com.yasser.features.details.data.datasource.remote.WordDictionaryApi
import com.yasser.features.details.domain.entity.WordInfoEntity
import com.yasser.features.details.domain.repository.WordDictionaryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordDictionaryRepositoryImp @Inject constructor(
    private val wordDictionaryApi: WordDictionaryApi,
    private val wordInfoDao: WordInfoDao,
    private val localDataStore: LocalDataStore
) : WordDictionaryRepository {
    private val TAG = "WordDictionaryRepositoryImp"
    private val wordsSearchKey = stringSetPreferencesKey("word_search")
    override suspend fun getWordInfo(word: String): Flow<ResponseStatus<List<WordInfoEntity>>> {
        saveSearchWordToDataStore(word)

        return wordDictionaryApi.getWorDictionaryInfo(word).safeApiCall(
            mapRemoteData = { remoteWordInfoList ->
                remoteWordInfoList.map { it.toWordInfoEntity() }
            },
            getFromLocalDB = {
                val localResult = wordInfoDao.getWordInfos(word)
                if (localResult.isNotEmpty())
                    localResult.map { it.toWordInfoEntity() }
                else
                    null
            },
            saveLocalDB = { remoteWordInfoList ->
                wordInfoDao.deleteWordInfos(remoteWordInfoList.map { it.word })
                wordInfoDao.insertWordInfos(remoteWordInfoList.map { it.toWordInfoLocalModel() })
            }
        )
    }



    private suspend fun saveSearchWordToDataStore(word: String) {
        val wordSearchSet = localDataStore.readFromDataStore(wordsSearchKey, setOf()).toMutableSet()
        wordSearchSet.add(word)
        localDataStore.writeToDataStore(
            key = wordsSearchKey,
            value = wordSearchSet
        )
    }
}