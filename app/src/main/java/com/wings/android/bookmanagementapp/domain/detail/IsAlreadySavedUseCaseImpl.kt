package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.data.repository.LocalBookRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class IsAlreadySavedUseCaseImpl @Inject constructor(
    private val repository: LocalBookRepository
) : IsAlreadySavedUseCase {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun invoke(isbn: Long): Flow<Boolean> {
        return repository.getBookList().flatMapLatest { books ->
            val isbnList = books.map { it.isbn }
            val isAlreadySaved = isbnList.contains(isbn)
            flowOf(isAlreadySaved)
        }
    }
}
