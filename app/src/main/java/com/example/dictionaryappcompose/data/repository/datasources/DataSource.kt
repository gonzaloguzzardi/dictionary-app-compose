package com.example.dictionaryappcompose.data.repository.datasources

import com.example.dictionaryappcompose.common.Resource
import com.example.dictionaryappcompose.data.repository.datasources.remote.dtos.DefinitionsApiResponse
import com.example.dictionaryappcompose.domain.model.Definition
import kotlinx.coroutines.flow.Flow

interface DataSource {
    suspend fun getDefinitionsForWord(word: String): Resource<List<Definition>>
}
