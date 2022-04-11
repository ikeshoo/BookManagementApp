package com.wings.android.bookmanagementapp.view.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.wings.android.bookmanagementapp.view.model.Book

@Composable
fun BookColumn(
    books: List<Book>,
    onClick: (Long) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(books) { book ->
            BookItem(
                book = book,
                onClick = onClick
            )
        }
    }
}

@Composable
fun BookItem(
    book: Book,
    onClick: (Long) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(book.isbn) }
    ) {
        Row() {
            Image(
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp),
                painter = rememberAsyncImagePainter(model = book.imageUrl),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            Column() {
                Text(text = book.title)
                Text(text = book.author)
            }
        }
    }
}
