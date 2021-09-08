package com.example.myapplication.domain.repository.detail_book

import com.example.myapplication.data.api.ApiQueries
import com.example.myapplication.data.remote.ApiRemote

import kotlinx.coroutines.flow.flow

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

class DetailBookRepositoryImpl(private val api:ApiRemote):DetailBookRepository {
    override fun getdetailBook(idBook: String) = flow {
        emit(api.getBookDetail("${ApiQueries.VOLUME}/$idBook"))
    }
}