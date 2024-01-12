package com.example.dictionaryappcompose.presentation.components.definitionsList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictionaryappcompose.R
import com.example.dictionaryappcompose.domain.model.Definition
import com.example.dictionaryappcompose.presentation.components.textIcon.TextIcon

@Composable
fun DefinitionListItem(definition: Definition, modifier: Modifier) {
    Card(
        modifier = modifier,
        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.tertiary),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = definition.definition ?: "",
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = definition.author ?: "",
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
                Row(verticalAlignment = Alignment.Bottom) {
                    TextIcon(
                        modifier = Modifier.wrapContentSize(),
                        text = (definition.upVotes ?: 0).toString(),
                        iconResource = R.drawable.ic_thumb_up
                    )
                    TextIcon(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .wrapContentSize(),
                        text = (definition.downVotes ?: 0).toString(),
                        iconResource = R.drawable.ic_thumb_down
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefinitionListItemPreview() {
    DefinitionListItem(
        definition = Definition(
            definition = "\"A word to use in place of, \"awesome,\" \"cool,\" \"[groovy],\" \"[rad],\" \"[fly],\" or any other words to describe something you find amazing.\"",
            author = "payinginpalaver",
            upVotes = 21,
            downVotes = 9
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
