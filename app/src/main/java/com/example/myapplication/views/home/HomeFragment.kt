package com.example.myapplication.views.home


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.base.fragment.BaseFragment
import com.example.myapplication.base.tools.liveDataObserver
import com.example.myapplication.databinding.HomeFragmentBinding
import com.example.myapplication.databinding.ItemBookListBinding
import com.example.myapplication.domain.models.response.Item
import com.example.myapplication.domain.vo.Resource
import com.example.myapplication.tools.DynamicBindingAdapter
import com.example.myapplication.tools.GlideModule
import com.example.myapplication.tools.extensions.afterTextChanged
import com.example.myapplication.tools.extensions.confgRecyclerBinding
import com.example.myapplication.tools.extensions.makeVisible
import com.example.myapplication.tools.extensions.setTextFromHtml
import org.koin.android.ext.android.inject
import kotlin.reflect.KClass

class HomeFragment :
    BaseFragment<HomeViewModel, HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    override val viewModelClass: KClass<HomeViewModel> = HomeViewModel::class

    private val glideModule: GlideModule by inject()

    private var adapter:DynamicBindingAdapter<Item>? = null


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerQueryRequest("cat")
        observerEditTextChanged()
        eventsViews()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun eventsViews(){
        binding.btnStyle.setOnCheckedChangeListener { compoundButton, b ->
            adapter?.let {
                binding.rcyBooks.confgRecyclerBinding(it,!b,b)
                binding.rcyBooks.adapter?.notifyDataSetChanged()
            }
        }

        binding.imgCleanSearch.setOnClickListener {
            binding.edtSearch.text.clear()
        }

        binding.btnMoreResults.setOnClickListener {

        }
    }


    private fun observerQueryRequest(query: String) =
        liveDataObserver(viewModel.getListBooks(query)) {
            it?.let {
                when (it) {
                    is Resource.Success -> {
                        it.data.also { bk ->
                            bk.items?.let { it1 -> configureList(it1) }
                        }
                    }
                    is Resource.Error -> {
                        viewModel.setSnackbarMessage( R.string.error_request)
                    }
                }
            }

        }

    @SuppressLint("SetTextI18n")
    private fun configureList(items: List<Item>) {
        binding.btnStyle.makeVisible(items.size > 0)
        binding.textResultSearch.text = "${resources.getString(R.string.text_result_search)}  ${items.size}"
        adapter = getAdapterBooks(items)
        adapter?.let {
            binding.rcyBooks.confgRecyclerBinding(it)
        }

    }

    private fun observerEditTextChanged(){
        binding.edtSearch.afterTextChanged {
            if(it.isEmpty()){
                observerQueryRequest("cat")
            }else{
                observerQueryRequest(it)
            }


        }
    }

    @SuppressLint("SetTextI18n")
    private fun getAdapterBooks(list: List<Item>): DynamicBindingAdapter<Item> {
        return DynamicBindingAdapter(
            R.layout.item_book_list,
            list
        ) { vh, view, data, pos ->
            view as ItemBookListBinding

            val volumeinfo = data.volumeInfo
            view.txtTitleBook.text = volumeinfo?.title.orEmpty()
            view.textViewTime.text = "Publisher:\n${volumeinfo?.publisher.orEmpty()}"
            view.textViewCommerceCategory.text = "Version:\n${volumeinfo?.contentVersion.orEmpty()}"
            view.textViewAmount setTextFromHtml data.searchInfo?.textSnippet.orEmpty()
            glideModule.loadImage(view.imageViewCover, volumeinfo?.imageLinks?.thumbnail.orEmpty())

            vh.itemView.setOnClickListener {
                viewModel.navigateTo(HomeFragmentDirections.actionHomeFragmentToDetailBook(data.id.orEmpty()))
            }
        }
    }



}


