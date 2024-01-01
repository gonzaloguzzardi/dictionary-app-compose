package com.example.dictionaryappcompose.domain.repository

import com.example.dictionaryappcompose.common.Resource
import com.example.dictionaryappcompose.domain.model.Definition

interface DictionaryRepository {
    suspend fun getDefinitionsForWord(word: String): Resource<List<Definition>>
}
