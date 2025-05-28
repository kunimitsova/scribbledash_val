package com.popcornissues.scribbledash

fun getLineStart(numSections: Int, sectionIndex: Int, size: Int): Float {
    if (numSections == 0) return 0f
    return (size.toFloat() * (sectionIndex.toFloat() / numSections.toFloat()))
}