package com.wings.android.bookmanagementapp.domain.search

import com.wings.android.bookmanagementapp.data.repository.SearchRepository
import com.wings.android.bookmanagementapp.data.source.remote.entity.SearchResult
import com.wings.android.bookmanagementapp.extension.toHttps
import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchByTitleUseCaseImpl @Inject constructor(
    private val repository: SearchRepository
) : SearchByTitleUseCase {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun invoke(title: String, page: Int): Flow<List<Book>> {
        return repository.searchByTitle(
            title = title,
            page = page
        ).flatMapLatest { response ->
            flow {
                val list = response.items.toBookList()
                emit(list)
            }
        }
    }

    private fun List<SearchResult>.toBookList(): List<Book> {
        return this.map { searchResult ->
            Book(
                title = searchResult.title,
                author = searchResult.author,
                imageUrl = searchResult.largeImageUrl,
                isbn = searchResult.isbn,
                size = searchResult.size,
                caption = searchResult.itemCaption
            )
        }
    }
}


