package com.popcornissues.scribbledash

import android.app.Application
import com.popcornissues.scribbledash.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ScribbledashApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ScribbledashApp)
            androidLogger()

            modules(AppModule)
        }
    }
}