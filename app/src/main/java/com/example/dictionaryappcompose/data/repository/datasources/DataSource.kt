package com.example.dictionaryappcompose.data.repository.datasources

import com.example.dictionaryappcompose.common.Resource
import com.example.dictionaryappcompose.domain.model.Definition

interface DataSource {
    suspend fun getDefinitionsForWord(word: String): Resource<List<Definition>>
}
