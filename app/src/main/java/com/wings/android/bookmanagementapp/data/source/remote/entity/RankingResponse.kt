package com.wings.android.bookmanagementapp.data.source.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RankingResponse(
    @SerialName("Items")
    val items: List<Ranking>,
    val lastBuildDate: String,
    val title: String
)
