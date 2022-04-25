package com.wings.android.bookmanagementapp.view.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailScreen(
    isbnCode: String?,
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val book by viewModel.book.collectAsState()
    LaunchedEffect(key1 = true) {
        isbnCode?.let {
            viewModel.getBook(it)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
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
        FloatingActionButton(
            modifier = Modifier.align(alignment = Alignment.End),
            onClick = {
            viewModel.saveBook()
            navController.popBackStack()
        }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }
    }
}
