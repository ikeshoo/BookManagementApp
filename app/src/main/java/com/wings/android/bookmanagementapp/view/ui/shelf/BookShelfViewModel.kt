package com.wings.android.bookmanagementapp.view.ui.shelf

import com.wings.android.bookmanagementapp.domain.shelf.GetBookListUseCase
import com.wings.android.bookmanagementapp.view.model.Book
import com.wings.android.bookmanagementapp.view.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BookShelfViewModel @Inject constructor(
    private val getBookListUseCase: GetBookListUseCase
) : BaseViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>>
        get() = _books

    fun getBookList() {
        getBookListUseCase().execute(
            onSuccess = { _books.value = it },
            retry = { getBookList() }
        )
    }
}
