package com.popcornissues.scribbledash.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.R
import com.popcornissues.scribbledash.ui.theme.LightPrimary
import com.popcornissues.scribbledash.ui.theme.LightSurfaceHigh
import com.popcornissues.scribbledash.ui.theme.LightSurfaceLow
import com.popcornissues.scribbledash.ui.theme.LightSurfaceLowest
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme

@Composable
fun BottomBar(
    paddingValues: PaddingValues
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(color = LightSurfaceHigh)
            .padding(bottom = paddingValues.calculateBottomPadding())
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = {},
            enabled = false,
            colors = IconButtonColors(
                containerColor = Color.Transparent,
                contentColor = LightPrimary,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = LightSurfaceLowest)
        ) {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.chart),
                contentDescription = stringResource(R.string.home)
            )
        }
        IconButton(
            onClick = {},
            enabled = true,
            colors = IconButtonColors(
                containerColor = Color.Transparent,
                contentColor = LightPrimary,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = LightSurfaceLowest)
        ) {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.home),
                contentDescription = stringResource(R.string.home)
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    ScribbledashTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = LightSurfaceLow),
            verticalArrangement = Arrangement.Bottom
        ) {
            BottomBar(
                paddingValues = PaddingValues(16.dp)
            )
        }
    }
}