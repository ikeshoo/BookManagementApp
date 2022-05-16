package com.wings.android.bookmanagementapp.view.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
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
            .padding(horizontal = 16.dp)
    ) {
        val centerModifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        Image(
            modifier = centerModifier
                .height(200.dp)
                .width(200.dp),
            painter = rememberAsyncImagePainter(book.imageUrl),
            contentDescription = null
        )
        DetailText(modifier = centerModifier, text = book.title)
        DetailText(modifier = centerModifier, text = book.author)
        OutlinedTextField(
            value = book.review ?: "",
            onValueChange = { viewModel.updateReview(it) }
        )
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

@Composable
fun DetailText(
    modifier: Modifier,
    text: String
) {
    Text(
        modifier = modifier.padding(top = 8.dp),
        text = text,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
        style = MaterialTheme.typography.titleMedium,
    )
}
