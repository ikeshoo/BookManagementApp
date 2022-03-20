package com.wings.android.bookmanagementapp.data.source.remote.entity

import kotlinx.serialization.Serializable

@Serializable
data class Ranking(
    val rank: Int,
    val itemName: String,
    val itemPrice: String,
    val itemCaption: String,
    val itemCode: String,
    val catchcopy: String,
    val itemUrl: String,
    val smallImageUrls: List<String>,
    val mediumImageUrls: List<String>,
    val reviewAverage: String,
    val reviewCount: Int,
    val genreId: String,
)
