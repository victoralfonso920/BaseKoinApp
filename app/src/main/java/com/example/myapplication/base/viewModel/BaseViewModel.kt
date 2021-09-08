package com.example.myapplication.base.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData import com.example.myapplication.R
import com.example.myapplication.base.tools.SingleLiveEvent
import com.example.myapplication.domain.vo.Resource
import com.example.myapplication.tools.loge
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect


// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

abstract class BaseViewModel :  BaseNavigationViewModel() {

    val snackbarErrorMessageLiveData = SingleLiveEvent<Int>()
    val snackbarSuccessMessageLiveData = SingleLiveEvent<Int>()

    private val loading = MutableLiveData<Boolean>()

    fun getLoading(): LiveData<Boolean> = loading

    init {
        loading.value = false
    }

    fun <T> safeApiCall(
        apiCall: suspend () -> Flow<T>
    ) = liveData {
        loading.value = true
        apiCall.invoke()
            .catch {
                loading.value = false
                it.message?.loge()
                emit(Resource.Error(it.message.orEmpty()))
            }
            .collect {
                loading.value = false
                emit(Resource.Success(it))
            }
    }

    fun setSnackbarMessage(message: Int = R.string.error_request, isError: Boolean = true) {
        if (isError) {
            snackbarErrorMessageLiveData.postValue(message)
            return
        }
        snackbarSuccessMessageLiveData.postValue(message)
    }
}
