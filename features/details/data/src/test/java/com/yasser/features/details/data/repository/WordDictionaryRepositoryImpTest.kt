package com.yasser.features.details.data.repository

import androidx.core.os.trace
import app.cash.turbine.test
import com.yasser.common.data.datasource.local.LocalDataStore
import com.yasser.common.domain.entity.network.ResponseStatus
import com.yasser.common.domain.entity.network.enums.ExceptionType
import com.yasser.features.details.data.datasource.local.WordInfoDao
import com.yasser.features.details.data.datasource.local.model.WordInfoLocalModel
import com.yasser.features.details.data.datasource.remote.WordDictionaryApi
import com.yasser.features.details.data.datasource.remote.model.WordInfoRemoteModel
import com.yasser.features.details.domain.entity.WordInfoEntity
import com.yasser.features.details.domain.repository.WordDictionaryRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkStatic
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import okio.IOException
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse


class WordDictionaryRepositoryImpTest {

    @MockK
    private lateinit var wordDictionaryApi: WordDictionaryApi

    @MockK
    private lateinit var wordInfoDao: WordInfoDao

    @MockK
    private lateinit var localDataStore: LocalDataStore

    private lateinit var wordDictionaryRepository: WordDictionaryRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        mockkStatic("retrofit2.KotlinExtensions")
        wordDictionaryRepository = WordDictionaryRepositoryImp(
            wordDictionaryApi,
            wordInfoDao,
            localDataStore
        )

    }



    @Test
    fun `getWordInfo success with remote data`() = runTest {
        val testWord = "test"
        val remoteWordInfoList = listOf(
            WordInfoRemoteModel(
                meanings = emptyList(),
                origin = "",
                phonetic = "",
                word = testWord
            )
        )

        val actualWordInfoList = listOf(
            WordInfoEntity(
                meanings = emptyList(),
                origin = "",
                phonetic = "",
                word = testWord
            )
        )
        // Mock the Retrofit Call object
        val mockCall = mockk<Call<List<WordInfoRemoteModel>>>()
        coEvery { wordDictionaryApi.getWorDictionaryInfo(testWord) }returns mockCall

        coEvery { mockCall.awaitResponse()} returns Response.success(remoteWordInfoList)

        coEvery {wordInfoDao.getWordInfos(testWord)} returns emptyList() // Simulate empty local database

        coEvery { localDataStore.readFromDataStore<Set<String>>(any(), any()) } returns setOf()


        wordDictionaryRepository.getWordInfo(testWord).test {
            val loading = awaitItem()
            val result = awaitItem()
            assertEquals(ResponseStatus.Success(actualWordInfoList), result)
            awaitComplete()
        }

        coVerify { wordInfoDao.deleteWordInfos(listOf(testWord))}
        coVerify {wordInfoDao.insertWordInfos(any())}
    }

    @Test
    fun `getWordInfo success with local data`() = runTest {
        val testWord = "test"
        val localWordInfoList = listOf(
            WordInfoLocalModel(
                meanings = emptyList(),
                origin = "",
                phonetic = "",
                word = testWord
            )
        )

        val actualWordInfoList = listOf(
            WordInfoEntity(
                meanings = emptyList(),
                origin = "",
                phonetic = "",
                word = testWord
            )
        )

        // Mock the Retrofit Call object
        val mockCall = mockk<Call<List<WordInfoRemoteModel>>>()
        coEvery { wordDictionaryApi.getWorDictionaryInfo(testWord) }returns mockCall

        coEvery { mockCall.awaitResponse()} throws IOException() // Simulate network error

        coEvery {wordInfoDao.getWordInfos(testWord)} returns localWordInfoList // Simulate empty local database

        coEvery { localDataStore.readFromDataStore<Set<String>>(any(), any()) } returns setOf()

        wordDictionaryRepository.getWordInfo(testWord).test {
            val loading = awaitItem()
            val result = awaitItem()
            assertEquals(ResponseStatus.Success(actualWordInfoList), result)
            awaitComplete()
        }

        coVerify(exactly = 0) { wordInfoDao.deleteWordInfos(listOf(testWord))}
        coVerify(exactly = 0) {wordInfoDao.insertWordInfos(any())}
    }

    @Test
    fun `getWordInfo error`() = runTest {
        val testWord = "test"

        val mockCall = mockk<Call<List<WordInfoRemoteModel>>>()
        coEvery { wordDictionaryApi.getWorDictionaryInfo(testWord) }returns mockCall

        coEvery { mockCall.awaitResponse()} throws IOException() // Simulate network error

        coEvery {wordInfoDao.getWordInfos(testWord)} returns emptyList() // Simulate empty local database

        coEvery { localDataStore.readFromDataStore<Set<String>>(any(), any()) } returns setOf()

        wordDictionaryRepository.getWordInfo(testWord).test {
            val loading = awaitItem()
            val result = awaitItem()
            assertEquals(ResponseStatus.Error<WordInfoEntity>(ExceptionType.Network), result)
            awaitComplete()
        }

        coVerify(exactly = 0) { wordInfoDao.deleteWordInfos(listOf(testWord))}
        coVerify(exactly = 0) {wordInfoDao.insertWordInfos(any())}
    }


}