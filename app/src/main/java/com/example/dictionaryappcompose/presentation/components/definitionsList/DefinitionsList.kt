package com.example.dictionaryappcompose.presentation.components.definitionsList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictionaryappcompose.domain.model.Definition

@Composable
fun DefinitionsList(modifier: Modifier, definitions: List<Definition>) {
    Box(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(
                items = definitions,
                key = { item -> item.definition.hashCode() }) { definition ->
                if (!definition.definition.isNullOrBlank()) {
                    DefinitionListItem(
                        definition = definition,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefinitionsListPreview() {
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
    DefinitionsList(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), definitions = definitions
    )
}
