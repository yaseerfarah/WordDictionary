package com.yasser.features.details.data.datasource.remote

import com.yasser.features.details.data.datasource.remote.model.WordInfoRemoteModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WordDictionaryApi {

    @GET("/api/v2/entries/en/{word}")
    fun getWorDictionaryInfo(
        @Path("word") word: String
    ): Call<List<WordInfoRemoteModel>>

}