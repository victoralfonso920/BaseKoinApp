package com.example.myapplication.tools

import android.util.Log
import com.example.myapplication.BuildConfig

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

fun String.loge() {
    if (BuildConfig.DEBUG)
     Log.e("miApp",this)
}
