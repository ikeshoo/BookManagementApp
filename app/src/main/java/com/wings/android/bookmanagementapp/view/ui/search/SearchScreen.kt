package com.wings.android.bookmanagementapp.view.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wings.android.bookmanagementapp.view.ui.common.BookColumn

@Composable
fun SearchScreen(
    moveDetail: (String) -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val books by viewModel.books.collectAsState()
    Column() {
        SearchView(onSearch = { viewModel.search(it) })
        BookColumn(
            books = books,
            onClick = moveDetail
        )
    }
}

@Composable
fun SearchView(
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { onSearch(text) }
        ),
        singleLine = true,
        maxLines = 1,
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    SearchScreen(
        moveDetail = { }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchView() {
    val viewModel: SearchViewModel = hiltViewModel()
    SearchView(onSearch = { viewModel.search(it) })
}
