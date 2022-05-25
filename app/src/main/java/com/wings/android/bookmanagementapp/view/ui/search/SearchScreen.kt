package com.wings.android.bookmanagementapp.view.ui.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wings.android.bookmanagementapp.view.ui.common.BookColumn
import kotlinx.coroutines.launch

@Composable
fun SearchScreen(
    moveDetail: (Long) -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val books by viewModel.books.collectAsState()
    Column() {
        SearchView(onSearch = { viewModel.search(it) })
        Box {
            val listState = rememberLazyListState()
            BookColumn(
                books = books,
                onClick = moveDetail,
                listState = listState
            )

            val shouldShowButton by remember {
                derivedStateOf { listState.firstVisibleItemIndex > 0 }
            }
            androidx.compose.animation.AnimatedVisibility(
                visible = shouldShowButton,
                modifier = Modifier.align(alignment = Alignment.BottomEnd)
            ) {
                val coroutineScope = rememberCoroutineScope()
                FloatingActionButton(
                    onClick = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(index = 0)
                        }
                    }) {
                    Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = null)
                }
            }
        }
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
