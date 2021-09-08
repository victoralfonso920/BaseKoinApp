package com.example.myapplication.views.home

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.base.viewModel.BaseViewModel
import com.example.myapplication.data.api.ApiKeys
import com.example.myapplication.domain.repository.books.BooksRepository
// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

class HomeViewModel(private val repo: BooksRepository) : BaseViewModel() {

    val maxResults = MutableLiveData<Int>()
    init {
        maxResults.value = 10
    }

    fun getListBooks(query: String) = safeApiCall {
        val data = HashMap<String, String>()
        data[ApiKeys.QUERY] = query
        data[ApiKeys.MAX_RESULTS] = maxResults.value.toString()

        repo.getBooks(data)
    }

}