package com.yasser.features.details.domain.entity


data class WordInfoEntity(
    val meanings: List<MeaningEntity>,
    val origin: String,
    val phonetic: String,
    val word: String
)