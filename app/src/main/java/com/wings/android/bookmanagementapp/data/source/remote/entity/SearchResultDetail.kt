package com.wings.android.bookmanagementapp.data.source.remote.entity

import kotlinx.serialization.Serializable

@Serializable
data class SearchResultDetail(
    val author: String,
    val authorKana: String,
    val isbn: String,
    val itemCaption: String,
    val itemPrice: Int,
    val itemUrl: String,
    val largeImageUrl: String,
    val limitedFlag: Int,
    val listPrice: Int,
    val mediumImageUrl: String,
    val publisherName: String,
    val reviewAverage: String,
    val reviewCount: Int,
    val salesDate: String,
    val seriesName: String,
    val seriesNameKana: String,
    val size: String,
    val smallImageUrl: String,
    val subTitle: String,
    val subTitleKana: String,
    val title: String,
    val titleKana: String
)
