package com.example.myapplication.base.tools

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

// Created by Victor Hernandez on 8/9/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(rootView.windowToken, 0)
}