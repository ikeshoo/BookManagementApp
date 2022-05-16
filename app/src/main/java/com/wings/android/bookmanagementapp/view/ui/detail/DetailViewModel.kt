package com.wings.android.bookmanagementapp.view.ui.detail

import com.wings.android.bookmanagementapp.domain.detail.GetBookUseCase
import com.wings.android.bookmanagementapp.domain.detail.SaveBookUseCase
import com.wings.android.bookmanagementapp.view.model.Book
import com.wings.android.bookmanagementapp.view.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getBookUseCase: GetBookUseCase,
    private val saveBookUseCase: SaveBookUseCase
) : BaseViewModel() {

    private val _book = MutableStateFlow(Book.Empty)
    val book: StateFlow<Book>
        get() = _book

    fun getBook(isbnCode: String) {
        getBookUseCase(isbnCode).execute(
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

    fun updateReview(review: String) {
        if (review == _book.value.review) return
        val new = _book.value.copy(review = review)
        _book.value = new
    }
}
