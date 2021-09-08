package com.example.myapplication.domain.repository.detail_book

import com.example.myapplication.domain.models.response.DetailBook
import kotlinx.coroutines.flow.Flow

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

interface DetailBookRepository {

    fun getdetailBook(idBook: String): Flow<DetailBook>
}