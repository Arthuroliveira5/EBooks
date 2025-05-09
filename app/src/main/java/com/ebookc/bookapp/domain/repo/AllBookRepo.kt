package com.ebookc.bookapp.domain.repo

import com.ebookc.bookapp.common.BookCategoryModel
import com.ebookc.bookapp.common.BookModel
import com.ebookc.bookapp.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {

    fun getAllBooks(): Flow<ResultState<List<BookModel>>>
    fun getAllCategory(): Flow<ResultState<List<BookCategoryModel>>>
    fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>>




}