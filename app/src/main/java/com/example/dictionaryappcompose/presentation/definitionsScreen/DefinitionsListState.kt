package com.example.dictionaryappcompose.presentation.definitionsScreen

import androidx.compose.runtime.Immutable
import com.example.dictionaryappcompose.domain.model.Definition

@Immutable
data class DefinitionsListState(
    val isLoading: Boolean = false,
    val definitions: List<Definition> = emptyList(),
    val error: String = ""
)
