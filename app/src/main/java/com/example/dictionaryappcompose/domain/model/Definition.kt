package com.example.dictionaryappcompose.domain.model

data class Definition(
    val definition: String,
    val author: String,
    val upVotes: Int,
    val downVotes: Int
)
