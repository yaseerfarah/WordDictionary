package com.yasser.features.details.data.di

import com.yasser.features.details.data.datasource.remote.WordDictionaryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteApiModule {

    @Provides
    @Singleton
    fun provideWordDictionaryApi(retrofit: Retrofit): WordDictionaryApi {
        return retrofit.create(WordDictionaryApi::class.java)
    }
}