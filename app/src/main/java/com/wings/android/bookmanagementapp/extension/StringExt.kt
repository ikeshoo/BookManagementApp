package com.wings.android.bookmanagementapp.extension

fun String.toHttps(): String {
    return this.replace("http", "https")
}

fun String.formatRankingTitle(): String {
    return this.replace("【楽天市場】ランキング市場 ", "")
}
