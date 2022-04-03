package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.data.source.local.PreferenceLocal
import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.BookList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalBookListRepositoryImpl @Inject constructor(
    private val dataStore: PreferenceLocal
) : LocalBookListRepository {
    override fun saveBook(bookList: BookList): Flow<Signal> {
        return dataStore.setBookList(bookList)
    }

    override fun getBookList(): Flow<BookList> {
        return dataStore.getBookList()
    }
}
