package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow

interface LocalBookRepository {

    fun initializeBook(book: Book): Flow<Signal>
    fun getBookList(): Flow<List<Book>>
    fun getBook(isbn: Long): Flow<Book>
    fun updateBook(book: Book): Flow<Signal>
}
