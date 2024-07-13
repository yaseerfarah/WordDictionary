package com.yasser.features.details.domain.usecase

import app.cash.turbine.test
import com.yasser.common.domain.entity.network.ResponseStatus
import com.yasser.common.domain.entity.network.enums.ExceptionType
import com.yasser.features.details.domain.entity.WordInfoEntity
import com.yasser.features.details.domain.repository.WordDictionaryRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

class GetWordDictionaryInfoUseCaseTest {

    @MockK
    private lateinit var wordDictionaryRepository: WordDictionaryRepository

    private lateinit var getWordDictionaryInfoUseCase: GetWordDictionaryInfoUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        getWordDictionaryInfoUseCase = GetWordDictionaryInfoUseCase(wordDictionaryRepository)
    }

    @Test
    fun `invoke returns word info from repository`() = runTest {
        val testWord = "test"
        val wordInfoList = listOf(
            WordInfoEntity(
                meanings = emptyList(),
                origin = "",
                phonetic = "",
                word = testWord
            )
        )
        val expectedResponse = ResponseStatus.Success(wordInfoList)

        coEvery { wordDictionaryRepository.getWordInfo(testWord) } returns flowOf(expectedResponse)

        getWordDictionaryInfoUseCase(testWord).test {
            assertEquals(expectedResponse, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `invoke returns error from repository`() = runTest {
        val testWord = "test"
        val expectedResponse = ResponseStatus.Error<List<WordInfoEntity>>(ExceptionType.Network)

        coEvery { wordDictionaryRepository.getWordInfo(testWord) } returns flowOf(expectedResponse)

        getWordDictionaryInfoUseCase(testWord).test {
            assertEquals(expectedResponse, awaitItem())
            awaitComplete()
        }
    }
}