package com.example.dictionaryappcompose.presentation.components.definitionsList

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictionaryappcompose.R
import com.example.dictionaryappcompose.domain.model.Definition
import com.example.dictionaryappcompose.presentation.components.shadow.HorizontalShadow

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DefinitionsList(
    modifier: Modifier,
    wordSearched: String,
    definitions: List<Definition>,
    shouldScrollToStart: Boolean = false
) {
    val lazyListState = rememberLazyListState()

    if (shouldScrollToStart) {
        LaunchedEffect(definitions) {
            lazyListState.scrollToItem(index = 0)
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = R.string.definitions_list_header, wordSearched),
            style = MaterialTheme.typography.titleMedium,
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Box(Modifier.fillMaxSize()) {
            LazyColumn(
                modifier =
                Modifier
                    .fillMaxSize(),
                state = lazyListState
            ) {
                items(
                    items = definitions,
                    key = { item -> item.definition.hashCode() }
                ) { definition ->
                    if (definition.definition.isNotBlank()) {
                        DefinitionListItem(
                            definition = definition,
                            modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                                .animateItemPlacement(
                                    animationSpec =
                                    spring(
                                        dampingRatio = Spring.DampingRatioNoBouncy,
                                        stiffness = Spring.StiffnessLow
                                    )
                                )
                        )
                    }
                }
            }
            if (lazyListState.canScrollBackward) {
                HorizontalShadow(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter),
                    descendingShadow = true,
                    height = 8.dp
                )
            }
            if (lazyListState.canScrollForward) {
                HorizontalShadow(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    descendingShadow = false,
                    height = 8.dp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefinitionsListPreview() {
    val definitions =
        mutableListOf(
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
        modifier =
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        wordSearched = "Quality",
        definitions = definitions
    )
}
