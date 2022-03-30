package com.wings.android.bookmanagementapp.data.source.local

import androidx.datastore.core.DataStore
import com.wings.android.bookmanagementapp.view.model.BookList

class PreferenceLocalImpl(
    private val dataStore: DataStore<BookList>
) : PreferenceLocal {
}
