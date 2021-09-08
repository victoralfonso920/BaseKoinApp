package com.example.myapplication.domain.models.response

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

data class DetailBook(
    val accessInfo: AccessInfo,
    val etag: String,
    val id: String,
    val kind: String,
    val saleInfo: SaleInfo,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)

