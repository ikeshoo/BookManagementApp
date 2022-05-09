package com.wings.android.bookmanagementapp.view.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

// ToDo: 必要なパラメータを追加していく
@Serializable
@Entity(tableName = "book_table2")
data class Book(
    val title: String,
    val author: String,
    val imageUrl: String?,
    @PrimaryKey
    val isbn: Long,
    val caption: String,
    val review: String?
) {
    companion object {
        val Empty = Book(
            title = "",
            author = "",
            imageUrl = null,
            isbn = 0L,
            caption = "",
            review = null
        )
    }
}
