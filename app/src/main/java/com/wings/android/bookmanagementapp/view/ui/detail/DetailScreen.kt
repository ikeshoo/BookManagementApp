package com.wings.android.bookmanagementapp.view.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailScreen(isbnCode: String?, viewModel: DetailViewModel = hiltViewModel()) {
    val book by viewModel.book.collectAsState()
    LaunchedEffect(key1 = true) {
        isbnCode?.let {
            viewModel.getBook(it)
        }
    }

    Column(
        modifier = Modifier
            .wrapContentWidth()
    ) {
        Image(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp),
            painter = rememberAsyncImagePainter(book.imageUrl),
            contentDescription = null
        )
        Text(text = book.title)
        Text(text = book.author)
    }
}
