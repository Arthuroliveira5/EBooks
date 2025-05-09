package com.ebookc.bookapp.common

import androidx.annotation.Keep

@Keep
data class BookModel(
    val bookname:String="",
    val bookAuthor:String="",
    val bookUrl:String="",
    val bookDescription:String="",
    val category:String="",
    val image:String="",



)
