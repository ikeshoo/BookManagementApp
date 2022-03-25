package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.data.source.remote.entity.SearchResponse
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun searchByTitle(title: String, page: Int): Flow<SearchResponse>
}
