package com.example.dictionaryappcompose.presentation.definitions_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictionaryappcompose.presentation.definitions_list.components.searchField.SearchField
import com.example.dictionaryappcompose.presentation.definitions_list.components.searchFilters.SearchFilters

@Composable
fun DefinitionsListScreen(viewModel: DefinitionsListViewModel = hiltViewModel()) {
    DefinitionsListScreenContent(
        onSearchWordPressed = viewModel::getDefinitionsByWord,
        onFilterApplied = viewModel::sortDefinitions
    )
}

@Composable
fun DefinitionsListScreenContent(
    onSearchWordPressed: (String) -> Unit,
    onFilterApplied: (Int) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
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
    }
}

@Preview(showBackground = true)
@Composable
fun DefinitionsListScreenPreview() {
    DefinitionsListScreenContent(
        onSearchWordPressed = {},
        onFilterApplied = {}
    )
}
