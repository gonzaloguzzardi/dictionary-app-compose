package com.example.dictionaryappcompose.presentation.definitionsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionaryappcompose.common.Resource
import com.example.dictionaryappcompose.domain.model.SortType
import com.example.dictionaryappcompose.domain.useCases.getDefinitions.GetDefinitionsUseCase
import com.example.dictionaryappcompose.domain.useCases.sortDefinitions.SortDefinitionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DefinitionsListViewModel @Inject constructor(
    private val getDefinitionsUseCase: GetDefinitionsUseCase,
    private val sortDefinitionsUseCase: SortDefinitionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DefinitionsListState())
    val uiState: StateFlow<DefinitionsListState> = _uiState.asStateFlow()

    fun getDefinitionsByWord(word: String) {
        getDefinitionsUseCase(word).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _uiState.update { currentState ->
                        currentState.copy(isLoading = true)
                    }
                }

                is Resource.Success -> {
                    _uiState.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            wordSearched = word,
                            definitions = result.data.orEmpty(),
                            shouldRestartScroll = true
                        )
                    }
                }

                is Resource.Error -> {
                    _uiState.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    fun sortDefinitions(sortTypeValue: Int) {
        val sortType = SortType.fromInt(sortTypeValue)
        val sortedDefinitions = sortDefinitionsUseCase(_uiState.value.definitions, sortType)
        _uiState.value = _uiState.value.copy(
            isLoading = false,
            definitions = sortedDefinitions,
            shouldRestartScroll = true
        )
    }
}
