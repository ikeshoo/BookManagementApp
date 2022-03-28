package com.wings.android.bookmanagementapp.view.ui.search

import com.wings.android.bookmanagementapp.domain.search.SearchByTitleUseCase
import com.wings.android.bookmanagementapp.view.model.Book
import com.wings.android.bookmanagementapp.view.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchByTitleUseCase: SearchByTitleUseCase
) : BaseViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>>
        get() = _books

    fun search(title: String, page: Int = 1) {
        searchByTitleUseCase(title, page).execute(
            onSuccess = {
                _books.value = it
            },
            retry = { search(title, page) }
        )
    }
}
