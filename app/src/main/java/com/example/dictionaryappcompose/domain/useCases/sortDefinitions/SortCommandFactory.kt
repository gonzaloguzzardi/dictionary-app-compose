package com.example.dictionaryappcompose.domain.useCases.sortDefinitions

import com.example.dictionaryappcompose.domain.model.SortType
import com.example.dictionaryappcompose.domain.useCases.sortDefinitions.sortCommands.LeastDownVotedSortCommand
import com.example.dictionaryappcompose.domain.useCases.sortDefinitions.sortCommands.LeastUpVotedSortCommand
import com.example.dictionaryappcompose.domain.useCases.sortDefinitions.sortCommands.MostDownVotedSortCommand
import com.example.dictionaryappcompose.domain.useCases.sortDefinitions.sortCommands.MostUpVotedSortCommand
import com.example.dictionaryappcompose.domain.useCases.sortDefinitions.sortCommands.SortCommand

object SortCommandFactory {
    fun createSortCommand(sortType: SortType): SortCommand {
        return when (sortType) {
            SortType.MostUpVoted -> MostUpVotedSortCommand()
            SortType.LeastUpVoted -> LeastUpVotedSortCommand()
            SortType.MostDownVoted -> MostDownVotedSortCommand()
            SortType.LeastDownVoted -> LeastDownVotedSortCommand()
        }
    }
}
