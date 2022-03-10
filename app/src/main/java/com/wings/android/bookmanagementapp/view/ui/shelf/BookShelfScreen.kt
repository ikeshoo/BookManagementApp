package com.wings.android.bookmanagementapp.view.ui.shelf

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.wings.android.bookmanagementapp.view.model.Book

// ToDo: 引数は暫定
@Composable
fun BookShelfScreen(books: List<Book>) {
    LazyColumn {
        items(books) { book ->

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfItem(book: Book) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Row() {
//            Image(
//                painter = rememberAsyncImagePainter(book.imageUrl),
//                contentScale = ContentScale.Crop,
//                contentDescription = null
//            )
            
            Column() {
                Text(text = book.title)
                Text(text = book.author)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookShelfPreview() {
    BookShelfScreen(books = emptyList())
}

@Preview(showBackground = true)
@Composable
fun BookShelfItemPreview() {
    BookShelfItem(book = Book.TEST)
}
