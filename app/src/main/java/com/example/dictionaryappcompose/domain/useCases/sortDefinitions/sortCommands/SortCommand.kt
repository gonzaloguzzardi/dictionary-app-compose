package com.example.dictionaryappcompose.domain.useCases.sortDefinitions.sortCommands

import com.example.dictionaryappcompose.domain.model.Definition

interface SortCommand {
    fun execute(definitions: List<Definition>): List<Definition>
}
