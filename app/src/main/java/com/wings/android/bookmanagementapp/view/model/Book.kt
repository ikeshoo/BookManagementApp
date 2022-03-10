package com.wings.android.bookmanagementapp.view.model

// ToDo: 必要なパラメータを追加していく
data class Book(
    val title: String,
    val author: String,
    val imageUrl: String?
) {
    companion object {
        val TEST = Book(
            title = "test",
            author = "test",
            imageUrl = "https://cdn-ak.f.st-hatena.com/images/fotolife/k/kuri_megane/20190901/20190901230015.jpg"
        )
    }
}
