/*
 * Create by Byron Solorzano on 27/1/2020.
 *
 * Copyright (c) 2020 Byron Solorzano.
 * All rights reserved.
 */

package com.example.myapplication.base.fragment

import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.myapplication.base.ObserverBase
import com.example.myapplication.base.tools.hideKeyboard
import com.example.myapplication.base.tools.liveDataObserver
import com.example.myapplication.base.viewModel.BaseViewModel

abstract class BaseNavigationFragment<VM : BaseViewModel> : BaseFragmentVM<VM>(), ObserverBase {

    protected val onClickPopBackStack: (View) -> Unit = {
        viewModel.popBackStack()
    }

    override fun setObservers() {
        setNavigationObserver()
    }

    private fun setNavigationObserver() {
        view?.hideKeyboard()

        liveDataObserver(viewModel.getNavigationLiveData()) { direction ->
            findNavController().navigate(direction)
        }

        liveDataObserver(viewModel.getPopBackStackWithDirectionLiveData()) { direction ->
            findNavController().popBackStack(direction, true)
        }

        liveDataObserver(viewModel.getPopBackStackLiveData()) {
            popBackStack()
        }
    }

    open fun popBackStack() {
        setFragmentNavigationResult()
        findNavController().popBackStack()
    }

    open fun setFragmentNavigationResult() {}
}
