package com.example.myapplication.base.fragment

import androidx.fragment.app.Fragment
import com.example.myapplication.base.ObserverBase
import com.example.myapplication.base.tools.liveDataObserver
import com.example.myapplication.base.viewModel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf
import kotlin.reflect.KClass


// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

abstract class BaseFragmentVM<VM : BaseViewModel> : Fragment() {


    protected abstract val viewModelClass: KClass<VM>

    protected open val viewModel: VM by lazy {
        getViewModel(clazz = viewModelClass) {
            getParametersOfInject()
        }
    }

    open fun getParametersOfInject() = parametersOf(arguments)



}

