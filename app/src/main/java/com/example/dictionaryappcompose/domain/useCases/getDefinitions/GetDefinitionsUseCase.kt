package com.example.dictionaryappcompose.domain.useCases.getDefinitions

import com.example.dictionaryappcompose.common.Resource
import com.example.dictionaryappcompose.domain.model.Definition
import com.example.dictionaryappcompose.domain.repository.DictionaryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDefinitionsUseCase @Inject constructor(
    private val repository: DictionaryRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<Definition>>> = flow {
        emit(Resource.Loading())
        emit(repository.getDefinitionsForWord(word))
    }
}
