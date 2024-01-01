package com.example.dictionaryappcompose.data.repository.datasources.remote.dtos

import com.google.gson.annotations.SerializedName

data class DefinitionDto(
    @SerializedName("definition") val definition: String?,
    @SerializedName("author") val author: String?,
    @SerializedName("thumbs_up") val upVotes: Int?,
    @SerializedName("thumbs_down") val downVotes: Int?
)
