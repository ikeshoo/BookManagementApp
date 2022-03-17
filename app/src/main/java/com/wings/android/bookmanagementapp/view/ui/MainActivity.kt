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
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wings.android.bookmanagementapp.view.model.AppScreens
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
        val allScreens = AppScreens.ALL
        val navController = rememberNavController()
        val backStackEntry = navController.currentBackStackEntryAsState()
        val currentScreen = AppScreens.fromRoute(
            backStackEntry.value?.destination?.route
        )
        Scaffold(
            topBar = { TopBar() },
            bottomBar = { BottomBar(
                screens = allScreens,
                currentScreen = currentScreen,
                onTabSelected = { screen ->
                    navController.navigate(screen.screenRoute) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) }
        ) {
            BookShelfNavHost(navController = navController)
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
fun BottomBar(
    screens: List<AppScreens>,
    currentScreen: AppScreens,
    onTabSelected: (AppScreens) -> Unit
) {
    BottomNavigation() {
        screens.forEach { screen ->
            BottomNavigationItem(
                selected = currentScreen == screen,
                onClick = { onTabSelected(screen) },
                label = { Text(text = stringResource(id = screen.textRes)) },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconRes),
                        contentDescription = stringResource(id = screen.textRes)
                    )
                },
                alwaysShowLabel = true,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(alpha = 0.3f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BookManagementApp()
}
