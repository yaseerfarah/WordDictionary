package com.yasser.common.domain.entity.network

import com.yasser.common.domain.entity.network.enums.ExceptionType

sealed class ResponseStatus<DATA> {

    class Loading<DATA> : ResponseStatus<DATA>()
    data class Success<DATA>(val data: DATA) : ResponseStatus<DATA>()
    data class Error<DATA>(val exceptionType: ExceptionType) : ResponseStatus<DATA>()

}