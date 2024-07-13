package com.yasser.features.details.data.datasource.remote.model

import com.yasser.features.details.data.datasource.local.model.WordInfoLocalModel
import com.yasser.features.details.domain.entity.WordInfoEntity


data class WordInfoRemoteModel(
    val meanings: List<MeaningRemoteModel> = emptyList(),
    val origin: String = "",
    val phonetic: String = "",
    val phonetics: List<PhoneticRemoteModel> =emptyList(),
    val word: String = ""
){
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaningEntity() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }


    fun toWordInfoLocalModel(): WordInfoLocalModel {
        return WordInfoLocalModel(
            meanings = meanings.map { it.toMeaningEntity() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}