package com.wings.android.bookmanagementapp.data.source.remote.entity

import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    val author: String,
    val isbn: String,
    val itemCaption: String,
    val itemUrl: String,
    val largeImageUrl: String,
    val mediumImageUrl: String,
    val publisherName: String,
    val reviewAverage: String,
    val reviewCount: Int,
    val salesDate: String,
    val smallImageUrl: String,
    val title: String,
)

fun List<SearchResult>.toBookList(): List<Book> {
    return this.map { searchResult ->
        Book(
            title = searchResult.title,
            author = searchResult.author,
            imageUrl = searchResult.largeImageUrl,
            isbn = searchResult.isbn,
            caption = searchResult.itemCaption
        )
    }
}
