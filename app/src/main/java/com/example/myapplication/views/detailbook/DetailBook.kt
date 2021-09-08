package com.example.myapplication.views.detailbook

import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.base.fragment.BaseFragment
import com.example.myapplication.base.tools.liveDataObserver
import com.example.myapplication.databinding.DetailBookFragmentBinding
import com.example.myapplication.domain.models.response.DetailBook
import com.example.myapplication.domain.vo.Resource
import com.example.myapplication.tools.GlideModule
import com.example.myapplication.tools.extensions.setTextFromHtml
import com.example.myapplication.tools.loge
import org.koin.android.ext.android.inject
import kotlin.reflect.KClass
// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

class DetailBook : BaseFragment<DetailBookViewModel,DetailBookFragmentBinding>(DetailBookFragmentBinding::inflate) {

    override val viewModelClass: KClass<DetailBookViewModel>  = DetailBookViewModel::class

    private val glideModule: GlideModule by inject()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val id = it.getString("id")
            observerDetailBook(id.orEmpty())
        }
        binding.imgBack.setOnClickListener {
            viewModel.popBackStack()
        }
    }

    private fun observerDetailBook(id: String) {
        liveDataObserver(viewModel.getDetailBook(id)){
            when (it) {
                is Resource.Success -> {
                    it.data.also { dtbk ->
                        updateUI(dtbk)
                    }
                }
                is Resource.Error -> {
                    viewModel.setSnackbarMessage( R.string.error_request)
                }
            }
        }
    }

    private fun updateUI(dtbk: DetailBook) {
        with(binding){

            val volumeinfo = dtbk.volumeInfo
            txtTitleBook.text = volumeinfo.title.orEmpty()
            textViewTime.text = "Publisher:\n${volumeinfo?.publisher.orEmpty()}"
            textViewCommerceCategory.text = "Version:\n${volumeinfo?.contentVersion.orEmpty()}"

            textViewAmount setTextFromHtml volumeinfo.description.orEmpty()

            glideModule.loadImage(imageViewCover,volumeinfo.imageLinks.thumbnail.orEmpty())

        }

    }

}