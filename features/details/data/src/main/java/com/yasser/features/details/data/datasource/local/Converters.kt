package com.yasser.features.details.data.datasource.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yasser.features.details.domain.entity.MeaningEntity

@ProvidedTypeConverter
class Converters(
    private val jsonParser: Gson
) {
    @TypeConverter
    fun fromJsonToMeaningsList(json: String): List<MeaningEntity> {
        return jsonParser.fromJson<ArrayList<MeaningEntity>>(
            json,
            object : TypeToken<ArrayList<MeaningEntity>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun fromMeaningsListToJson(meanings: List<MeaningEntity>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<MeaningEntity>>(){}.type
        ) ?: "[]"
    }
}