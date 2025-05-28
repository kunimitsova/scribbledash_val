package com.popcornissues.scribbledash.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.popcornissues.scribbledash.getLineStart
import com.popcornissues.scribbledash.ui.theme.LightOnSurfaceVariant
import com.popcornissues.scribbledash.ui.theme.LightSurfaceHigh
import com.popcornissues.scribbledash.ui.theme.ScribbledashTheme

@Composable
fun Gridlines(
    canvasSize: Int,
    numSlices: Int,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier.fillMaxSize()
    ) {
        // horizontal gridlines
        for (i in 1..numSlices) {
            drawLine(
                color = LightOnSurfaceVariant,
                start = Offset(
                    x = 0f,
                    y = getLineStart(numSections = numSlices, sectionIndex = i, canvasSize)
                ),
                end = Offset(
                    x = canvasSize.toFloat(),
                    y = getLineStart(numSections = numSlices, sectionIndex = i, canvasSize)
                ),
                strokeWidth = 1.dp.toPx()
            )
        }
        // vertical gridlines
        for (i in 1..numSlices) {
            drawLine(
                color = LightOnSurfaceVariant,
                start = Offset(
                    x = getLineStart(numSections = numSlices, sectionIndex = i, canvasSize),
                    y = 0f
                ),
                end = Offset(
                    x = getLineStart(numSections = numSlices, sectionIndex = i, canvasSize),
                    y = canvasSize.toFloat(),
                ),
                strokeWidth = 1.dp.toPx()
            )
        }
    }
}

@Preview
@Composable
fun GridlinesPreview() {
    var canvasSize by remember { mutableIntStateOf(0) }
    val numSlices = 3
    ScribbledashTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f, matchHeightConstraintsFirst = false)
                .background(color = LightSurfaceHigh)
                .onGloballyPositioned {
                    canvasSize = it.size.height
                }
        ) {
            Gridlines(
                canvasSize = canvasSize,
                numSlices = numSlices
            )
        }
    }
}