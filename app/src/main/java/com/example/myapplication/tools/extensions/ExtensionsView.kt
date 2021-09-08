package com.example.myapplication.tools.extensions

import android.os.Build
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.tools.DynamicBindingAdapter
import com.google.android.material.snackbar.Snackbar

// Created by Victor Hernandez on 30/7/21.
// Proyect My Application
//contact victoralfonso920@gmail.com

fun View.snackbar(message: String, isError: Boolean = false) {
    val snack = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    (snack.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView).also {
        it.setTextColor(ContextCompat.getColor(this.context, R.color.white))
        it.typeface = ResourcesCompat.getFont(context, R.font.roboto_bold)
        it.gravity = Gravity.CENTER
    }

    if (isError) {
        snack.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.persian_red))
    } else {
        snack.view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.mountain_meadow))
    }
    snack.show()
}
fun <T> RecyclerView.confgRecyclerBinding(
    adapter: DynamicBindingAdapter<T>,
    isVertical: Boolean = true,
    isgrid: Boolean = false
) {
    itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
    if (isgrid) {
        layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
    } else {
        layoutManager = LinearLayoutManager(
            context,
            if (isVertical) RecyclerView.VERTICAL else RecyclerView.HORIZONTAL, false
        )
    }

    this.adapter = adapter
}

 infix fun TextView.setTextFromHtml(html: String){
    this.text  = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(html)
    }
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun View.makeVisible(isVisible:Boolean = false) {
   visibility = if (isVisible) View.VISIBLE else View.GONE

}


