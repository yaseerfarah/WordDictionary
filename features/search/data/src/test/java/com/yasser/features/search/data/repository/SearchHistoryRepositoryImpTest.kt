package com.yasser.features.search.data.repository

import androidx.core.os.trace
import app.cash.turbine.test
import com.yasser.common.data.datasource.local.LocalDataStore
import com.yasser.features.search.domain.repository.SearchHistoryRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf

import kotlinx.coroutines.test.runTest
import net.bytebuddy.matcher.ElementMatchers.any
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SearchHistoryRepositoryImpTest {
    @MockK
    private lateinit var localDataStore: LocalDataStore

    private lateinit var searchHistoryRepository: SearchHistoryRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        searchHistoryRepository = SearchHistoryRepositoryImp(localDataStore)
    }

    @Test
    fun `getSearchHistory returns emptylist when no history is stored`() = runTest {
        every { localDataStore.readFromDataStoreAsFlow<Set<String>>(any(), any()) } returns flowOf(emptySet())

        searchHistoryRepository.getSearchHistory().test {
            assertEquals(emptyList<String>(), awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `getSearchHistory returns stored search history`() = runTest {
        val expectedHistory = listOf("apple", "banana", "cherry")
        every { localDataStore.readFromDataStoreAsFlow<Set<String>>(any(), any()) } returns flowOf(
            expectedHistory.toSet()
        )

        searchHistoryRepository.getSearchHistory().test {
            assertEquals(expectedHistory, awaitItem())
            awaitComplete()
        }
    }
}