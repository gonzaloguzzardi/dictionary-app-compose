package com.example.dictionaryappcompose.data.repository.datasources.remote.apis

import com.example.dictionaryappcompose.BuildConfig
import com.example.dictionaryappcompose.data.repository.datasources.remote.dtos.DefinitionsApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DictionaryRapidApi {
    @Headers(
        "x-rapidapi-key: ${BuildConfig.RAPID_API_KEY}",
        "x-rapidapi-host: mashape-community-urban-dictionary.p.rapidapi.com",
        "useQueryString: true"
    )
    @GET("/define")
    suspend fun getDefinitionForWord(@Query("term") word: String): DefinitionsApiResponse
}
