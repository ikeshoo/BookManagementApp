package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow

interface SearchByIsbnUseCase {
    operator fun invoke(isbnCode: String): Flow<Book>
}
