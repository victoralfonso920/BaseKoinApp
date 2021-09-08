/*
 * Create by Byron Solorzano on 27/1/2020.
 *
 * Copyright (c) 2020 Byron Solorzano.
 * All rights reserved.
 */

package com.example.myapplication.base.viewModel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.myapplication.base.tools.SingleLiveEvent

abstract class BaseNavigationViewModel : ViewModel() {

    private val navigation: SingleLiveEvent<NavDirections> = SingleLiveEvent()
    private val navigationBackStackWithDirection: SingleLiveEvent<Int> = SingleLiveEvent()
    private val navigationBackStack: SingleLiveEvent<Boolean> = SingleLiveEvent()

    fun getNavigationLiveData(): SingleLiveEvent<NavDirections> = navigation
    fun getPopBackStackWithDirectionLiveData(): SingleLiveEvent<Int> = navigationBackStackWithDirection
    fun getPopBackStackLiveData(): SingleLiveEvent<Boolean> = navigationBackStack

    fun navigateTo(direction: NavDirections) {
        navigation.postValue(direction)
    }

    fun popBackStackWithDirection(direction: Int) {
        navigationBackStackWithDirection.postValue(direction)
    }

    fun popBackStack() {
        navigationBackStack.postValue(true)
    }
}
