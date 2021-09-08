package com.example.myapplication.domain.vo

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
}

