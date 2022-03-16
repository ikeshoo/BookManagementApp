package com.wings.android.bookmanagementapp.view.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.wings.android.bookmanagementapp.R

sealed class BottomBarItem(
    @StringRes
    val textRes: Int,
    @DrawableRes
    val iconRes: Int,
    val screenRoute: String
) {
    object BookShelf : BottomBarItem(
        R.string.bottom_bar_shelf,
        R.drawable.ic_baseline_menu_book_24,
        "bookShelf"
    )

    object Search : BottomBarItem(
        R.string.bottom_bar_search,
        R.drawable.ic_baseline_search_24,
        "search"
    )

    // ToDo: もう一つくらい追加する？
}

