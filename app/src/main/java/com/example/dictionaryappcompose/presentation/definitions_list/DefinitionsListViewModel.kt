package com.example.dictionaryappcompose.presentation.definitions_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionaryappcompose.common.Resource
import com.example.dictionaryappcompose.domain.model.SortType
import com.example.dictionaryappcompose.domain.useCases.getDefinitions.GetDefinitionsUseCase
import com.example.dictionaryappcompose.domain.useCases.sortDefinitions.SortDefinitionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DefinitionsListViewModel @Inject constructor(
    private val getDefinitionsUseCase: GetDefinitionsUseCase,
    private val sortDefinitionsUseCase: SortDefinitionsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(DefinitionsListState())
    val state: State<DefinitionsListState> = _state

    fun getDefinitionsByWord(word: String) {
        getDefinitionsUseCase(word).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = DefinitionsListState(
                        isLoading = true,
                        definitions = state.value.definitions
                    )
                }

                is Resource.Success -> {
                    _state.value = DefinitionsListState(
                        isLoading = false,
                        definitions = result.data.orEmpty(),
                    )
                }

                is Resource.Error -> {
                    _state.value = DefinitionsListState(
                        isLoading = false,
                        definitions = state.value.definitions,
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun sortDefinitions(sortTypeValue: Int) {
        val sortType = SortType.fromInt(sortTypeValue)
        val sortedDefinitions = sortDefinitionsUseCase(_state.value.definitions, sortType)
        _state.value = DefinitionsListState(
            isLoading = false,
            definitions = sortedDefinitions,
        )
    }
}
