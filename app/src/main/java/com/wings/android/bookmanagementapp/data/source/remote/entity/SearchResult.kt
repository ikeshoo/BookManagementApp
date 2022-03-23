package com.wings.android.bookmanagementapp.data.source.remote.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("Item")
    val item: SearchResultDetail
)
