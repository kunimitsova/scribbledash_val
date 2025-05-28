package com.popcornissues.scribbledash.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme

@Composable
fun AppTitleText(title: String,
    modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium,
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}

@Preview
@Composable
fun AppTitleTextPreview() {
    ScribbledashTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            AppTitleText(
                title = stringResource(R.string.app_name)
            )
        }
    }
}