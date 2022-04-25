package com.wings.android.bookmanagementapp.view.ui.detail

import com.wings.android.bookmanagementapp.domain.detail.SaveBookUseCase
import com.wings.android.bookmanagementapp.domain.detail.SearchByIsbnUseCase
import com.wings.android.bookmanagementapp.util.Signal
import com.wings.android.bookmanagementapp.view.model.Book
import com.wings.android.bookmanagementapp.view.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val searchByIsbnUseCase: SearchByIsbnUseCase,
    private val saveBookUseCase: SaveBookUseCase
) : BaseViewModel() {

    private val _book = MutableStateFlow(Book.Empty)
    val book: StateFlow<Book>
        get() = _book

    fun getBook(isbnCode: String) {
        searchByIsbnUseCase(isbnCode).execute(
            onSuccess = {
                _book.value = it
            },
            retry = { getBook(isbnCode) }
        )
    }

    fun saveBook() {
        saveBookUseCase(_book.value).execute(
            onSuccess = { /* NOP */ },
            retry = { saveBook() }
        )
    }
}
