package com.wings.android.bookmanagementapp.view.ui.shelf

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.wings.android.bookmanagementapp.view.ui.common.BookColumn

@Composable
fun BookShelfScreen(
    moveDetail: (Long) -> Unit,
    viewModel: BookShelfViewModel = hiltViewModel()
) {
    val books by viewModel.books.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.getBookList()
    }
    BookColumn(
        books = books,
        onClick = moveDetail
    )
}

@Preview(showBackground = true)
@Composable
fun BookShelfPreview() {
    BookShelfScreen(
        moveDetail = { }
    )
}
