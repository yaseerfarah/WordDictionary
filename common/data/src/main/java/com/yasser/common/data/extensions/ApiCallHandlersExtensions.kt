package com.yasser.common.data.extensions

import android.util.Log
import com.yasser.common.domain.entity.network.ResponseStatus
import com.yasser.common.domain.entity.network.enums.ExceptionType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.Call
import retrofit2.awaitResponse

suspend fun <REMOTE_DATA, MAPPED_DATA> Call<REMOTE_DATA>.safeApiCall(
    mapRemoteData: (REMOTE_DATA) -> MAPPED_DATA,
    getFromLocalDB: suspend () -> MAPPED_DATA?,
    saveLocalDB: suspend (REMOTE_DATA) -> Unit
): Flow<ResponseStatus<MAPPED_DATA>> {
    return flow {
        try {
            emit(ResponseStatus.Loading())

            val response = awaitResponse()

            if (response.isSuccessful) {

                response.body()?.let {
                    saveLocalDB(it)
                    emit(ResponseStatus.Success(mapRemoteData(it)))
                } ?:
                emit(ResponseStatus.Error(ExceptionType.Empty))

            } else if (response.code() == 404){
                emit(ResponseStatus.Error(ExceptionType.Empty))
            }else {
                emit(ResponseStatus.Error(ExceptionType.Unknown))
            }

        } catch (e: IOException) {
            emit(getFromLocalDB()?.let {
                ResponseStatus.Success(it)
            } ?: ResponseStatus.Error(ExceptionType.Network))

        } catch (e: Exception) {
            emit(ResponseStatus.Error(ExceptionType.Unknown))
        }
    }
}