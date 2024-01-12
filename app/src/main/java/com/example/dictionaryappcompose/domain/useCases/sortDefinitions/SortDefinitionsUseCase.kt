package com.example.dictionaryappcompose.domain.useCases.sortDefinitions

import com.example.dictionaryappcompose.domain.model.Definition
import com.example.dictionaryappcompose.domain.model.SortType
import javax.inject.Inject

class SortDefinitionsUseCase @Inject constructor() {
    operator fun invoke(definitions: List<Definition>, sortType: SortType): List<Definition> {
        val sortCommand = SortCommandFactory.createSortCommand(sortType)
        return sortCommand.execute(definitions)
    }
}
