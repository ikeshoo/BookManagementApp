package com.wings.android.bookmanagementapp.data.source.local

import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.BookList
import kotlinx.coroutines.flow.Flow

interface PreferenceLocal {

    fun getBookList(): Flow<BookList>

    fun setBookList(new: BookList): Flow<Signal>
}
