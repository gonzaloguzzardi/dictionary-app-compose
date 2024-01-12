package com.example.dictionaryappcompose.data.repository.datasources.remote.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DefinitionsApiResponse(@SerialName("list") val definitions: List<DefinitionDto>?)
