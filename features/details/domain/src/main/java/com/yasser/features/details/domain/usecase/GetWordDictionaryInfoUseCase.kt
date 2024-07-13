package com.yasser.features.details.domain.usecase

import com.yasser.common.domain.entity.network.ResponseStatus
import com.yasser.common.domain.usecase.base.BaseSuspendUseCase
import com.yasser.features.details.domain.entity.WordInfoEntity
import com.yasser.features.details.domain.repository.WordDictionaryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWordDictionaryInfoUseCase @Inject constructor(
    private val wordDictionaryRepository: WordDictionaryRepository,
    ):BaseSuspendUseCase<String, Flow<ResponseStatus<List<WordInfoEntity>>>> {

    override suspend fun invoke(word: String): Flow<ResponseStatus<List<WordInfoEntity>>> {
        return wordDictionaryRepository.getWordInfo(word)
    }

}