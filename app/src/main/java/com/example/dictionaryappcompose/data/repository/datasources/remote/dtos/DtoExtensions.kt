package com.example.dictionaryappcompose.data.repository.datasources.remote.dtos

import com.example.dictionaryappcompose.domain.model.Definition

internal fun DefinitionsApiResponse.toDomainDefinitions(): List<Definition> {
    if (definitions.isNullOrEmpty()) return emptyList()

    return definitions.map { definitionDto ->
        Definition(
            definition = definitionDto.definition,
            author = definitionDto.author,
            upVotes = definitionDto.upVotes, downVotes = definitionDto.downVotes
        )
    }
}
