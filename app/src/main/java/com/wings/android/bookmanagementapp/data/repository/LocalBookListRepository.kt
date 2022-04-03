package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.BookList
import kotlinx.coroutines.flow.Flow

interface LocalBookListRepository {

    fun saveBook(bookList: BookList): Flow<Signal>
    fun getBookList(): Flow<BookList>
}
