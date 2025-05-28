package com.popcornissues.scribbledash.drawingscreens

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

data class DrawingState(
    val selectedColor: Color = Color.Companion.Black,
    val currentPath: PathData? = null,
    val paths: List<PathData> = emptyList(),
    val undoList: List<PathData> = emptyList()
)

data class PathData(
    val id: String,
    val color:  Color,
    val path: List<Offset>
)