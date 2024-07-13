package com.yasser.features.search.domain.usecase

import com.yasser.common.domain.usecase.base.BaseUseCase
import com.yasser.features.search.domain.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWordSearchHistoryUseCase  @Inject constructor(
    private val searchHistoryRepository: SearchHistoryRepository,
): BaseUseCase<Unit,Flow<List<String>>> {
    override fun invoke(input: Unit): Flow<List<String>> {
        return searchHistoryRepository.getSearchHistory()
    }
}