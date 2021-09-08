package com.example.myapplication.di.module_providers

import com.example.myapplication.di.module_tools.ModuleTools
import com.example.myapplication.domain.repository.books.BookRepositoryImpl
import com.example.myapplication.domain.repository.books.BooksRepository
import com.example.myapplication.domain.repository.detail_book.DetailBookRepository
import com.example.myapplication.domain.repository.detail_book.DetailBookRepositoryImpl
import com.example.myapplication.views.detailbook.DetailBookViewModel
import com.example.myapplication.views.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

object ModuleProviders {

    fun getModulesToDi() = arrayListOf<Module>().apply {
        add(ModuleTools.moduleTools)
        add(moduleRepository)
        add(moduleVm)
    }

    private val moduleRepository: Module = module {
        single <BooksRepository>{ BookRepositoryImpl(get()) }
        single <DetailBookRepository>{ DetailBookRepositoryImpl(get()) }
    }

    private val moduleVm: Module = module {
        viewModel { HomeViewModel(get()) }
        viewModel { DetailBookViewModel(get()) }
    }

}