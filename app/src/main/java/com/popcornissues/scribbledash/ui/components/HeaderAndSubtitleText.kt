package com.popcornissues.scribbledash.introscreens.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme

@Composable
fun HeaderAndSubtitleText(
    header: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = header,
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Companion.Center,
            modifier = Modifier.Companion.fillMaxWidth()
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Companion.Center,
            modifier = Modifier.Companion.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun HeaderAndSubtitleTextPreview() {
    ScribbledashTheme {
        Row(modifier = Modifier.Companion.fillMaxWidth()) {
            HeaderAndSubtitleText(
                header = stringResource(R.string.start_drawing),
                subtitle = stringResource(R.string.select_game_mode)
            )
        }
    }
}