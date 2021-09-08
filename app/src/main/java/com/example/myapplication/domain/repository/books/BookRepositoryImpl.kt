package com.example.myapplication.domain.repository.books

import com.example.myapplication.data.api.ApiQueries
import com.example.myapplication.data.remote.ApiRemote
import kotlinx.coroutines.flow.flow

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

class BookRepositoryImpl (private val api:ApiRemote) : BooksRepository{
    override suspend fun getBooks( data: HashMap<String, String>) = flow {
       emit(api.getBooks(ApiQueries.VOLUME,data))
    }

}