package com.example.dictionaryappcompose.presentation.definitionsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictionaryappcompose.domain.model.Definition
import com.example.dictionaryappcompose.presentation.components.definitionsList.DefinitionsList
import com.example.dictionaryappcompose.presentation.components.searchField.SearchField
import com.example.dictionaryappcompose.presentation.components.searchFilters.SearchFilters

@Composable
fun DefinitionsListScreen(viewModel: DefinitionsListViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    DefinitionsListScreenContent(
        uiState = uiState,
        onSearchWordPressed = viewModel::getDefinitionsByWord,
        onFilterApplied = viewModel::sortDefinitions
    )
}

@Composable
fun DefinitionsListScreenContent(
    uiState: DefinitionsListState,
    onSearchWordPressed: (String) -> Unit,
    onFilterApplied: (Int) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = Modifier.padding(16.dp),
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            SearchField(modifier = Modifier.fillMaxWidth(),
                onSearchWordPressed = { wordToSearch ->
                    onSearchWordPressed(wordToSearch)
                })
            SearchFilters(modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
                onFilterApplied = { sortTypeValue ->
                    onFilterApplied(sortTypeValue)
                })
            if (uiState.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                if (uiState.definitions.isNotEmpty()) {
                    DefinitionsList(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp),
                        wordSearched = uiState.wordSearched,
                        definitions = uiState.definitions
                    )
                } else if (uiState.error.isNotBlank()) {
                    LaunchedEffect(snackbarHostState) {
                        snackbarHostState.showSnackbar(
                            message = uiState.error,
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefinitionsListScreenPreview() {
    val definitions = mutableListOf(
        Definition(
            definition = "\"A word to use in place of, \"awesome,\" \"cool,\" \"[groovy],\" \"[rad],\" \"[fly],\" or any other words to describe something you find amazing.\"",
            author = "payinginpalaver",
            upVotes = 21,
            downVotes = 9
        ),
        Definition(
            definition = "\"Describes something as [very good]. Used mainly by [the British] [teenagers] and the LPcool.\"",
            author = "Louie Kay",
            upVotes = 131,
            downVotes = 29
        )
    )
    DefinitionsListScreenContent(
        uiState = DefinitionsListState(isLoading = false, definitions = definitions, error = ""),
        onSearchWordPressed = {},
        onFilterApplied = {}
    )
}
