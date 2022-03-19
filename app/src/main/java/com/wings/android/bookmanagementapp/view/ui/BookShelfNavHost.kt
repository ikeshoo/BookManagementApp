package com.wings.android.bookmanagementapp.view.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wings.android.bookmanagementapp.view.model.AppScreens
import com.wings.android.bookmanagementapp.view.ui.ranking.RankingScreen
import com.wings.android.bookmanagementapp.view.ui.search.SearchScreen
import com.wings.android.bookmanagementapp.view.ui.shelf.BookShelfScreen

@Composable
fun BookShelfNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.BookShelf.screenRoute,
        modifier = modifier
    ) {
        composable(AppScreens.BookShelf.screenRoute) {
            BookShelfScreen()
        }

        composable(AppScreens.Search.screenRoute) {
            SearchScreen()
        }

        composable(AppScreens.Ranking.screenRoute) {
            RankingScreen()
        }
    }
}
