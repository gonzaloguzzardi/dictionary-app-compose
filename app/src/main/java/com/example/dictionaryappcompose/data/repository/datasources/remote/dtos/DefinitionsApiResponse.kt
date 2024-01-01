package com.example.dictionaryappcompose.data.repository.datasources.remote.dtos

import com.google.gson.annotations.SerializedName

data class DefinitionsApiResponse(@SerializedName("list") val definitions: List<DefinitionDto>?)
