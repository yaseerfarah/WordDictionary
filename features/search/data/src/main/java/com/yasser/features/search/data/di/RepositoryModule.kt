package com.yasser.features.search.data.di

import com.yasser.features.search.data.repository.SearchHistoryRepositoryImp
import com.yasser.features.search.domain.repository.SearchHistoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSearchHistoryRepository(
        wordDictionaryRepositoryImp: SearchHistoryRepositoryImp
    ): SearchHistoryRepository

}