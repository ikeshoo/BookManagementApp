package com.wings.android.bookmanagementapp.domain.detail

import com.wings.android.bookmanagementapp.data.repository.SearchRepository
import com.wings.android.bookmanagementapp.data.source.remote.entity.toBookList
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchByIsbnUseCaseImpl @Inject constructor(
    private val repository: SearchRepository
) : SearchByIsbnUseCase {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun invoke(isbnCode: String): Flow<Book> {
        return repository.searchByIsbn(isbnCode)
            .flatMapLatest { response ->
                flow {
                    val book =
                        response.items.toBookList().firstOrNull() ?: Book.Empty
                    emit(book)
                }
            }
    }
}
