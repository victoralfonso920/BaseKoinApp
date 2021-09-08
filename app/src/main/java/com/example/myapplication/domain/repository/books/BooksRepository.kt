package com.example.myapplication.domain.repository.books

import com.example.myapplication.domain.models.response.BookList
import kotlinx.coroutines.flow.Flow

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

interface BooksRepository {
    suspend fun getBooks( data: HashMap<String, String>): Flow<BookList>
}