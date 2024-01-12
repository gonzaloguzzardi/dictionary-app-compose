package com.example.dictionaryappcompose.data.repository.datasources.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DefinitionDto(
    @SerialName("definition") val definition: String?,
    @SerialName("author") val author: String?,
    @SerialName("thumbs_up") val upVotes: Int?,
    @SerialName("thumbs_down") val downVotes: Int?
)
