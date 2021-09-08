package com.example.myapplication.base.tools

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

inline fun <T> Fragment.liveDataObserver(liveData: LiveData<T>?, crossinline func: (T) -> (Unit)) {
    liveData?.observe(viewLifecycleOwner, { observer -> func(observer) })
}
