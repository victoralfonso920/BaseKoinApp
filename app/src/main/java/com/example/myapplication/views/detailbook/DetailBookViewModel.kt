package com.example.myapplication.views.detailbook

import com.example.myapplication.base.viewModel.BaseViewModel
import com.example.myapplication.domain.repository.detail_book.DetailBookRepository
// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

class DetailBookViewModel(private val repo: DetailBookRepository) : BaseViewModel() {

    fun getDetailBook(idBook:String) = safeApiCall{
        repo.getdetailBook(idBook)
    }
}