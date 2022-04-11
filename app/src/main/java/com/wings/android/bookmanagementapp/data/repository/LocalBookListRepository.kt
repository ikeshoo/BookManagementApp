package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow

interface LocalBookListRepository {

    fun saveBook(book: Book): Flow<Signal>
    fun getBookList(): Flow<Book>
}
