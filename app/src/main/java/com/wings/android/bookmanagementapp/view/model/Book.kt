package com.wings.android.bookmanagementapp.view.model

import kotlinx.serialization.Serializable

// ToDo: 必要なパラメータを追加していく
@Serializable
data class Book(
    val title: String,
    val author: String,
    val imageUrl: String?,
    val isbn: String,
    val size: String,
    val caption: String,
) {
    companion object {
        val TEST = Book(
            title = "test",
            author = "test",
            imageUrl = "https://cdn-ak.f.st-hatena.com/images/fotolife/k/kuri_megane/20190901/20190901230015.jpg",
            isbn = "test",
            size = "test",
            caption = "test"
        )
    }
}

@Serializable
data class BookList(
    val value: List<Book>
) {
    companion object {
        val Default = BookList(
            value = emptyList()
        )
    }
}
