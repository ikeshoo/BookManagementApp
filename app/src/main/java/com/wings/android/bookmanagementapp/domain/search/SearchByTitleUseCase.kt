package com.wings.android.bookmanagementapp.domain.search

import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow

interface SearchByTitleUseCase {

    operator fun invoke(title: String, page: Int): Flow<List<Book>>
}
