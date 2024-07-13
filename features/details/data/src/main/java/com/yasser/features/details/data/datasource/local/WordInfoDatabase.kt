package com.yasser.features.details.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yasser.features.details.data.datasource.local.model.WordInfoLocalModel

@Database(
    entities = [WordInfoLocalModel::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val dao: WordInfoDao
}