package com.popcornissues.scribbledash.ui

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.popcornissues.scribbledash.R

val BagelOneFamily = FontFamily(
    Font(R.font.bagel_fat_one,
        weight = FontWeight.Normal
        )
)

val OutfitFamily = FontFamily(
    listOf(Font(R.font.outfit,
        weight = FontWeight.Normal
        ),
        Font(
            R.font.outfit_medium,
            weight = FontWeight.Medium
        ),
        Font(
            R.font.outfit_semibold,
            weight = FontWeight.SemiBold
        )
    )
)