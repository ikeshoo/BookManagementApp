package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.data.repository.LocalBookListRepository
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookListUseCaseImpl @Inject constructor(
    private val repository: LocalBookListRepository
) : GetBookListUseCase {
    override fun invoke(): Flow<Book> {
        return repository.getBookList()
    }
}
