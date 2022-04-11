package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.data.repository.LocalBookRepository
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookListUseCaseImpl @Inject constructor(
    private val repository: LocalBookRepository
) : GetBookListUseCase {
    override fun invoke(isbn: Long): Flow<Book> {
        return repository.getBook(isbn)
    }
}
