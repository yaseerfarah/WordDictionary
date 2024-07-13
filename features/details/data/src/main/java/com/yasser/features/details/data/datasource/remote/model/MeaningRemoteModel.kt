package com.yasser.features.details.data.datasource.remote.model

import com.yasser.features.details.domain.entity.MeaningEntity


data class MeaningRemoteModel(
    val definitions: List<DefinitionRemoteModel> = emptyList(),
    val partOfSpeech: String = ""
){
    fun toMeaningEntity(): MeaningEntity {
        return MeaningEntity(
            definitions = definitions.map { it.toDefinitionEntity() },
            partOfSpeech = partOfSpeech
        )
    }
}