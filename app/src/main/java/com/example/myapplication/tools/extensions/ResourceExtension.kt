package com.example.myapplication.tools

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

fun Context?.getResourceDrawable(id: Int): Drawable? {
    return if (this != null) {
        ContextCompat.getDrawable(this, id)
    } else null
}

fun Context?.getResourceColor(id: Int): Int {
    return if (this != null) {
        ContextCompat.getColor(this, id)
    } else 0
}

fun Context?.getResourceBitmap(resource: Int): Bitmap? {
    return if (this != null) {
        (getResourceDrawable(resource) as BitmapDrawable).bitmap
    } else null
}
