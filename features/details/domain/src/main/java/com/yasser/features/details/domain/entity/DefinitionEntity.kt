package com.yasser.features.details.domain.entity



data class DefinitionEntity(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
)