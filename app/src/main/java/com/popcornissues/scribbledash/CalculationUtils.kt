package com.popcornissues.scribbledash

import android.util.Size
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.max
import kotlin.math.max

fun getLineStart(numSections: Int, sectionIndex: Int, size: Int): Float {
    if (numSections == 0) return 0f
    return (size.toFloat() * (sectionIndex.toFloat() / numSections.toFloat()))
}