package com.yasser.features.details.data.datasource.remote.model

import com.yasser.features.details.domain.entity.PhoneticEntity


data class PhoneticRemoteModel(
    val audio: String = "",
    val text: String = ""
){
    fun toPhoneticEntity() = PhoneticEntity(
        audio = audio,
        text = text
    )

}