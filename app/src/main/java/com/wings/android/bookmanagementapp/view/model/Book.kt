package com.wings.android.bookmanagementapp.view.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

// ToDo: 必要なパラメータを追加していく
@Serializable
@Entity(tableName = "book_table")
data class Book(
    val title: String,
    val author: String,
    val imageUrl: String?,
    @PrimaryKey
    val isbn: Long,
    val caption: String,
) {
    companion object {
        val TEST = Book(
            title = "test",
            author = "test",
            imageUrl = "https://cdn-ak.f.st-hatena.com/images/fotolife/k/kuri_megane/20190901/20190901230015.jpg",
            isbn = 0L,
            caption = "test"
        )

        val Empty = Book(
            title = "",
            author = "",
            imageUrl = null,
            isbn = 0L,
            caption = ""
        )
    }
}
