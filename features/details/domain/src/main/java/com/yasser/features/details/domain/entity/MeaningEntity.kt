package com.yasser.features.details.domain.entity


data class MeaningEntity(
    val definitions: List<DefinitionEntity>,
    val partOfSpeech: String
)