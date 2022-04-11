package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.data.source.local.BookDao
import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalBookListRepositoryImpl @Inject constructor(
    private val bookDao: BookDao
) : LocalBookListRepository {
    override fun saveBook(book: Book): Flow<Signal> {
        return flow {
            emit(Signal)
        }
    }

    override fun getBookList(): Flow<Book> {
        return flow {
            emit(Book.TEST)
        }
    }
}
