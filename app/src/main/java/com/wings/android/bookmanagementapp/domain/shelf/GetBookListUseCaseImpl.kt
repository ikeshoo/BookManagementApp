package com.wings.android.bookmanagementapp.domain.shelf

import com.wings.android.bookmanagementapp.data.repository.LocalBookRepository
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookListUseCaseImpl @Inject constructor(
    private val repository: LocalBookRepository
) : GetBookListUseCase {
    override fun invoke(): Flow<List<Book>> {
        return repository.getBookList()
    }
}
