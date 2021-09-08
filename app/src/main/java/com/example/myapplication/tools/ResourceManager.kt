package com.example.myapplication.tools

import android.app.KeyguardManager
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.annotation.DimenRes
import androidx.annotation.StringRes

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

class ResourceManager (val context: Context) {

    val resources: Resources = context.resources

    fun getString(@StringRes resourceId: Int, params: Any? = null) = resources.getString(
        resourceId,
        params
    )

    fun getDrawable(resource: Int) = context.getResourceDrawable(resource)

    fun getDimensionPixelSize(@DimenRes res: Int) = resources.getDimensionPixelSize(res)

    fun getDimensionPixelOffset(@DimenRes res: Int) = resources.getDimensionPixelOffset(res)

    fun getKeyguardManager() = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager?

    fun generateToast(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show()
    }
}
