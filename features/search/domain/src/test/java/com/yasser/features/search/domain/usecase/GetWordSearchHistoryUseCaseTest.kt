package com.yasser.features.search.domain.usecase

import app.cash.turbine.test
import com.yasser.features.search.domain.repository.SearchHistoryRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GetWordSearchHistoryUseCaseTest {

    @MockK
    private lateinit var searchHistoryRepository: SearchHistoryRepository

    private lateinit var getWordSearchHistoryUseCase: GetWordSearchHistoryUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        getWordSearchHistoryUseCase = GetWordSearchHistoryUseCase(searchHistoryRepository)
    }

    @Test
    fun `invoke returns search history from repository`() = runTest {
        val expectedHistory = listOf("apple", "banana", "cherry")
        every { searchHistoryRepository.getSearchHistory() } returns flowOf(expectedHistory)

        getWordSearchHistoryUseCase(Unit).test {
            assertEquals(expectedHistory, awaitItem())
            awaitComplete()
        }
    }

}