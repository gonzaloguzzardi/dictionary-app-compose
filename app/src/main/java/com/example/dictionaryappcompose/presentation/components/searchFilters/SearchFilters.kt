package com.example.dictionaryappcompose.presentation.components.searchFilters

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictionaryappcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchFilters(modifier: Modifier = Modifier, onFilterApplied: (Int) -> Unit) {
    val sortOptions = stringArrayResource(id = R.array.search_filters_sort_options)

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(sortOptions[0]) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            modifier = Modifier.height(IntrinsicSize.Min),
            onExpandedChange = {
                expanded = !expanded
            },
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                label = {
                    Text(
                        text = stringResource(id = R.string.search_filters_sort_label),
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                textStyle = MaterialTheme.typography.labelLarge,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
                colors =
                TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                sortOptions.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = item,
                                style = MaterialTheme.typography.labelMedium
                            )
                        },
                        onClick = {
                            selectedText = item
                            expanded = false
                            onFilterApplied(sortOptions.indexOf(item))
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchFiltersPreview() {
    SearchFilters(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {}
}
