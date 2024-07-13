package com.yasser.features.details.data.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yasser.features.details.domain.entity.MeaningEntity
import com.yasser.features.details.domain.entity.WordInfoEntity

@Entity
data class WordInfoLocalModel(
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<MeaningEntity>,
    @PrimaryKey val id: Int? = null
){
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings,
            word = word,
            origin = origin,
            phonetic = phonetic,
        )
    }
}

