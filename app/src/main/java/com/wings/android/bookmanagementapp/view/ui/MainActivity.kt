package com.wings.android.bookmanagementapp.view.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.wings.android.bookmanagementapp.view.model.BottomBarItem
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
            bottomBar = { BottomBar() }
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

@Composable
fun BottomBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(BottomBarItem.BookShelf, BottomBarItem.Search)
    BottomNavigation() {
        items.forEachIndexed{ index, item ->
            BottomNavigationItem(
                selected = selectedItem == index,
                onClick = { selectedItem = index },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = stringResource(id = item.textRes)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BookManagementApp()
}
