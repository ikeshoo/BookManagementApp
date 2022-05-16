package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.data.source.local.BookDao
import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalBookRepositoryImpl @Inject constructor(
    private val bookDao: BookDao
) : LocalBookRepository {
    override fun initializeBook(book: Book): Flow<Signal> {
        return flow {
            bookDao.insert(book)
            emit(Signal)
        }
    }

    override fun getBookList(): Flow<List<Book>> {
        return bookDao.getAll()
    }

    override fun getBook(isbn: Long): Flow<Book> {
        return bookDao.getBook(isbn)
    }

    override fun updateBook(book: Book): Flow<Signal> {
        return flow {
            bookDao.update(book)
            emit(Signal)
        }
    }
}
