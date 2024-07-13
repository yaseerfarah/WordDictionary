package com.yasser.features.details.data.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.yasser.features.details.data.datasource.local.Converters
import com.yasser.features.details.data.datasource.local.WordInfoDao
import com.yasser.features.details.data.datasource.local.WordInfoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDBModule {


    @Provides
    @Singleton
    fun provideWordInfoDao(@ApplicationContext appContext: Context): WordInfoDao {
        return Room.databaseBuilder(
            appContext, WordInfoDatabase::class.java, "word_dictionary_db"
        ).addTypeConverter(Converters(GsonBuilder().create()))
            .build().dao
    }

}