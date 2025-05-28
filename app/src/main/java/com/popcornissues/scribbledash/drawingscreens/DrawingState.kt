package com.popcornissues.scribbledash.drawingscreens

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.popcornissues.scribbledash.domain.Constants.Companion.MAX_UNDOS
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
// is this right?

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