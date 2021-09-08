package com.example.myapplication.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.myapplication.base.tools.liveDataObserver
import com.example.myapplication.base.viewModel.BaseViewModel
import com.example.myapplication.tools.extensions.snackbar
import kotlin.reflect.KClass

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VM : BaseViewModel, LB : ViewBinding>(
    private val inflate: Inflate<LB>,
) : BaseNavigationFragment<VM>() {

    private var _binding: LB? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    override fun setObservers() {
        super.setObservers()
        setAdditionalObservers()
        setFragmentObservers()
        setSnackbarObserver()
    }

    private fun setSnackbarObserver() {
        liveDataObserver(viewModel.snackbarErrorMessageLiveData) { message ->
            binding.root.snackbar(getString(message), true)
        }
        liveDataObserver(viewModel.snackbarSuccessMessageLiveData) { message ->
            binding.root.snackbar(getString(message))
        }
    }




}