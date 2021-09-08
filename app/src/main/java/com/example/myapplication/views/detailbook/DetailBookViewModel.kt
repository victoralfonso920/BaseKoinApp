package com.example.myapplication.views.detailbook

import com.example.myapplication.base.viewModel.BaseViewModel
import com.example.myapplication.domain.repository.detail_book.DetailBookRepository

class DetailBookViewModel(private val repo: DetailBookRepository) : BaseViewModel() {

    fun getDetailBook(idBook:String) = safeApiCall{
        repo.getdetailBook(idBook)
    }
}