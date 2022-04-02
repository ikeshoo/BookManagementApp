package com.wings.android.bookmanagementapp.data.source.local

import androidx.datastore.core.DataStore
import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.BookList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PreferenceLocalImpl(
    private val dataStore: DataStore<BookList>
) : PreferenceLocal {
    override fun getBookList(): Flow<BookList> {
        return dataStore.data
    }

    override fun setBookList(new: BookList): Flow<Signal> {
        return flow {
            dataStore.updateData { new }
            emit(Signal)
        }
    }
}
