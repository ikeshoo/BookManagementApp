package com.wings.android.bookmanagementapp.data.source.remote.entity

import com.wings.android.bookmanagementapp.view.model.Book
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    val author: String,
    val authorKana: String,
    val isbn: String,
    val itemCaption: String,
    val itemUrl: String,
    val largeImageUrl: String,
    val mediumImageUrl: String,
    val publisherName: String,
    val reviewAverage: String,
    val reviewCount: Int,
    val salesDate: String,
    val seriesName: String,
    val seriesNameKana: String,
    val size: String,
    val smallImageUrl: String,
    val subTitle: String,
    val subTitleKana: String,
    val title: String,
    val titleKana: String
)

fun List<SearchResult>.toBookList(): List<Book> {
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
