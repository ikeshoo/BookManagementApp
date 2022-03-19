package com.wings.android.bookmanagementapp.view.ui.shelf

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.wings.android.bookmanagementapp.view.model.Book

// ToDo: 引数は暫定
@Composable
fun BookShelfScreen() {
    val dummyBooks = createDummyList()
    LazyColumn(
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {
        items(dummyBooks) { book ->
            BookShelfItem(book = book)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelfItem(book: Book) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                painter = rememberAsyncImagePainter(book.imageUrl),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .fillMaxWidth()
            ) {
                val modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                Text(
                    modifier = modifier,
                    text = book.title,
                )
                Text(
                    modifier = modifier,
                    text = book.author
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookShelfPreview() {
    BookShelfScreen()
}

@Preview(showBackground = true)
@Composable
fun BookShelfItemPreview() {
    BookShelfItem(book = Book.TEST)
}

private fun createDummyList(): List<Book> =
    listOf(
        Book(
            title = "Title1",
            author = "Author1",
            imageUrl = "https://cdn-ak.f.st-hatena.com/images/fotolife/k/kuri_megane/20190901/20190901230015.jpg"
        ),
        Book(
            title = "Title2",
            author = "Author2",
            imageUrl = "https://cdn-ak.f.st-hatena.com/images/fotolife/k/kuri_megane/20190901/20190901230015.jpg"
        ),
    )
