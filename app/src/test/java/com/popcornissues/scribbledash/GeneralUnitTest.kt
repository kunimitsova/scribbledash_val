package com.popcornissues.scribbledash

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GeneralUnitTest {
    @Test
    fun loc_calc_is_correct() {
        val canvasSize = 99
        val numSections = 3
        val sectionNum = 1
        assertEquals(33f, getLineStart(numSections, sectionNum, canvasSize))
    }
}