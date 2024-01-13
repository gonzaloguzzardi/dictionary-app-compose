package com.example.dictionaryappcompose.presentation.components.textIcon

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dictionaryappcompose.R

@Composable
fun TextIcon(modifier: Modifier, text: String, @DrawableRes iconResource: Int) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = ImageVector.vectorResource(id = iconResource),
            contentDescription = null
        )
        Text(text = text, modifier = Modifier.padding(start = 4.dp), style = MaterialTheme.typography.labelMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun TextIconPreview() {
    TextIcon(
        modifier = Modifier.fillMaxWidth(),
        text = "31",
        iconResource = R.drawable.ic_thumb_up
    )
}
