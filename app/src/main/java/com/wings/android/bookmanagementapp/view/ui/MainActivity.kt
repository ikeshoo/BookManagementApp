package com.wings.android.bookmanagementapp.view.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wings.android.bookmanagementapp.view.theme.BookManagementAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookManagementApp()
        }
    }
}

@Composable
fun BookManagementApp() {
    BookManagementAppTheme {
        Scaffold(
            topBar = { TopBar() },
            bottomBar = { }
        ) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
    CenterAlignedTopAppBar(
        title = { Text(text = "タイトル") },
        scrollBehavior = scrollBehavior
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BookManagementApp()
}
