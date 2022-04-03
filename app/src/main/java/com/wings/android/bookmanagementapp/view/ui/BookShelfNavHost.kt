package com.wings.android.bookmanagementapp.view.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wings.android.bookmanagementapp.view.model.AppScreens
import com.wings.android.bookmanagementapp.view.ui.detail.DetailScreen
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
        modifier = modifier.padding(bottom = 48.dp)
    ) {
        composable(AppScreens.BookShelf.screenRoute) {
            BookShelfScreen()
        }

        composable(AppScreens.Search.screenRoute) {
            SearchScreen(
                moveDetail = { navController.navigate("detail/$it") }
            )
        }

        composable(AppScreens.Ranking.screenRoute) {
            RankingScreen()
        }
        
        composable(
            route = AppScreens.Detail.screenRoute,
            arguments = listOf(navArgument("isbnCode") { type = NavType.StringType })
        ) { navBackStackEntry ->  
            DetailScreen(isbnCode = navBackStackEntry.arguments?.getString("isbnCode"))
        }
    }
}
