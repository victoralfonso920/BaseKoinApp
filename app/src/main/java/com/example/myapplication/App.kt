package com.example.myapplication

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.example.myapplication.di.module_providers.ModuleProviders
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        startDI()
    }

    private fun startDI() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(ModuleProviders.getModulesToDi())
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


}