package com.example.dictionaryappcompose.domain.model

enum class SortType {
    MostUpVoted,
    LeastUpVoted,
    MostDownVoted,
    LeastDownVoted;

    companion object {
        fun fromInt(value: Int): SortType =
            entries.firstOrNull { it.ordinal == value } ?: MostUpVoted
    }
}
