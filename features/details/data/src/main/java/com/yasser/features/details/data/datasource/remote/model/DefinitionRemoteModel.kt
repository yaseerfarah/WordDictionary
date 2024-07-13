package com.yasser.features.details.data.datasource.remote.model

import com.yasser.features.details.domain.entity.DefinitionEntity


data class DefinitionRemoteModel(
    val antonyms: List<String> = emptyList(),
    val definition: String = "",
    val example: String? = null,
    val synonyms: List<String> = emptyList()
){
    fun toDefinitionEntity(): DefinitionEntity {
        return DefinitionEntity(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}
