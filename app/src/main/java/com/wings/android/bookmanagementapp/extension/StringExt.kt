package com.wings.android.bookmanagementapp.extension

fun String.toHttps(): String {
    return this.replace("http", "https")
}
