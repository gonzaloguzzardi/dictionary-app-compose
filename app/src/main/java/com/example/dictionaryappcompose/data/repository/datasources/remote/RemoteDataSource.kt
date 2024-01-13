package com.example.dictionaryappcompose.data.repository.datasources.remote

import com.example.dictionaryappcompose.common.Resource
import com.example.dictionaryappcompose.data.repository.datasources.DataSource
import com.example.dictionaryappcompose.data.repository.datasources.remote.apis.DictionaryRapidApi
import com.example.dictionaryappcompose.data.repository.datasources.remote.dtos.toDomainDefinitions
import com.example.dictionaryappcompose.domain.model.Definition
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: DictionaryRapidApi
) : DataSource {
    override suspend fun getDefinitionsForWord(word: String): Resource<List<Definition>> {
        return try {
            val definitionsResponse = api.getDefinitionForWord(word)
            Resource.Success(definitionsResponse.toDomainDefinitions())
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        } catch (_: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        } catch (_: Exception) {
            Resource.Error("Unknown Error. Try again later")
        }
    }
}
