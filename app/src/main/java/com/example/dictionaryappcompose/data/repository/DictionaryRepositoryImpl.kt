package com.example.dictionaryappcompose.data.repository

import com.example.dictionaryappcompose.common.Resource
import com.example.dictionaryappcompose.data.repository.datasources.DataSource
import com.example.dictionaryappcompose.domain.model.Definition
import com.example.dictionaryappcompose.domain.repository.DictionaryRepository
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(private val remoteDataSource: DataSource) :
    DictionaryRepository {
    override suspend fun getDefinitionsForWord(word: String): Resource<List<Definition>> {
        return remoteDataSource.getDefinitionsForWord(word)
    }
}
