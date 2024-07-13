package com.yasser.features.details.data.di

import com.yasser.features.details.data.repository.WordDictionaryRepositoryImp
import com.yasser.features.details.domain.repository.WordDictionaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindWordDictionaryRepository(
        wordDictionaryRepositoryImp: WordDictionaryRepositoryImp
    ): WordDictionaryRepository

}