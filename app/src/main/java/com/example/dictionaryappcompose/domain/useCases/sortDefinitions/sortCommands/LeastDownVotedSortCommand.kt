package com.example.dictionaryappcompose.domain.useCases.sortDefinitions.sortCommands

import com.example.dictionaryappcompose.domain.model.Definition

class LeastDownVotedSortCommand : SortCommand {
    override fun execute(definitions: List<Definition>): List<Definition> =
        definitions.sortedBy { it.downVotes }
}
