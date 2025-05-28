package com.popcornissues.scribbledash.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.theme.LightOnSurface
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme

@Composable
fun CloseButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
    ) {
        Icon(ImageVector.vectorResource(R.drawable.close_circle),
            contentDescription = stringResource(R.string.close),
            tint = LightOnSurface
        )
    }
}

@Preview
@Composable
fun CloseButtonPreview() {
    ScribbledashTheme {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End)
        {
            CloseButton(
                onClick = {}
            )
        }
    }
}