package com.example.myapplication.tools

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.os.Build
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

class GlideModule {

    fun loadImage(img: ImageView, resource: Any) {
        val options = RequestOptions()
            .priority(Priority.HIGH)
            .format(getDecodeFormat(img.context))
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .dontAnimate()
            .fitCenter()

        Glide.with(img.context)
            .asBitmap()
            .load(resource)
            .apply(options)
            .into(img)
    }

    private fun getDecodeFormat(context: Context): DecodeFormat {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N || hasLowMemory(context)) {
            DecodeFormat.PREFER_RGB_565
        } else {
            DecodeFormat.PREFER_ARGB_8888
        }
    }

    private fun hasLowMemory(context: Context): Boolean {
        val activityManager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        return activityManager.isLowRamDevice
    }
}
