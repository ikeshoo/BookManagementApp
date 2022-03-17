package com.wings.android.bookmanagementapp.view.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wings.android.bookmanagementapp.view.model.AppScreens

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
        // ToDo: 画面の中身は暫定。正しいレイアウトを作成する。
        composable(AppScreens.BookShelf.screenRoute) {
            Text(text = stringResource(id = AppScreens.BookShelf.textRes))
        }

        composable(AppScreens.Search.screenRoute) {
            Text(text = stringResource(id = AppScreens.Search.textRes))
        }

        composable(AppScreens.Ranking.screenRoute) {
            Text(text = stringResource(id = AppScreens.Ranking.textRes))
        }
    }
}
