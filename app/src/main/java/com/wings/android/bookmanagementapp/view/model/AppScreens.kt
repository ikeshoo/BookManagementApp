package com.wings.android.bookmanagementapp.view.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.wings.android.bookmanagementapp.R

sealed class AppScreens(
    @StringRes
    val textRes: Int,
    @DrawableRes
    val iconRes: Int,
    val screenRoute: String,
    val showNavIcon: Boolean
) {
    companion object {
        val ALL = listOf(
            BookShelf,
            Search,
            Ranking
        )

        fun fromRoute(route: String?): AppScreens {
            return when (route) {
                BookShelf.screenRoute, null -> BookShelf
                Search.screenRoute -> Search
                Ranking.screenRoute -> Ranking
                Detail.screenRoute -> Detail
                else -> throw IllegalArgumentException("Route $route is not correct")
            }
        }
    }

    object BookShelf : AppScreens(
        R.string.bottom_bar_shelf,
        R.drawable.ic_baseline_menu_book_24,
        "bookShelf",
        false
    )

    object Search : AppScreens(
        R.string.bottom_bar_search,
        R.drawable.ic_baseline_search_24,
        "search",
        false
    )

    object Ranking : AppScreens(
        R.string.bottom_bar_ranking,
        R.drawable.ic_baseline_military_tech_24,
        "ranking",
        false
    )

    object Detail : AppScreens(
        R.string.detail_title,
        0,
        "detail/{isbnCode}",
        true
    )
}

