package com.example.myapplication.data.remote

import com.example.myapplication.domain.models.response.BookList
import com.example.myapplication.domain.models.response.DetailBook
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

interface ApiRemote {
    @GET("{sufijourl}")
    suspend fun getBooks(
        @Path("sufijourl") sufijourl: String,
        @QueryMap data: Map<String, String>
    ):BookList

    @GET("{sufijourl}")
    suspend fun getBookDetail(
        @Path("sufijourl",encoded = true) sufijourl: String
    ):DetailBook
}