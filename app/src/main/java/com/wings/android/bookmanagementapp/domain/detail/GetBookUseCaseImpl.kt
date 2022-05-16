package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.data.repository.LocalBookRepository
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class GetBookUseCaseImpl @Inject constructor(
    private val repository: LocalBookRepository,
    private val isAlreadySavedUseCase: IsAlreadySavedUseCase,
    private val searchByIsbnUseCase: SearchByIsbnUseCase
) : GetBookUseCase {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun invoke(isbn: String): Flow<Book> {
        return isAlreadySavedUseCase(isbn.toLong())
            .flatMapLatest { isAlreadySaved ->
                if (isAlreadySaved) repository.getBook(isbn.toLong())
                else searchByIsbnUseCase(isbn)
            }
    }
}
