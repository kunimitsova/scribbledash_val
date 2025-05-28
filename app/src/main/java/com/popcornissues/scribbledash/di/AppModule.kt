package com.popcornissues.scribbledash.di

import com.popcornissues.scribbledash.drawingscreens.DrawingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val AppModule = module {
    viewModelOf(::DrawingViewModel)
}