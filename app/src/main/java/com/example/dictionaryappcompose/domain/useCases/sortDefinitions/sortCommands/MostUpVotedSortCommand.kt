package com.example.dictionaryappcompose.domain.useCases.sortDefinitions.sortCommands

import com.example.dictionaryappcompose.domain.model.Definition

class MostUpVotedSortCommand : SortCommand {
    override fun execute(definitions: List<Definition>): List<Definition> =
        definitions.sortedByDescending { it.upVotes }
}
