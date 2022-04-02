package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.data.source.remote.RaktenApi
import com.wings.android.bookmanagementapp.data.source.remote.entity.SearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val raktenApi: RaktenApi
) : SearchRepository {

    override fun searchByTitle(title: String, page: Int): Flow<SearchResponse> {
        return flow {
            val response = raktenApi.searchByTitle(
                title = title,
                page = page
            )
            emit(response)
        }
    }

    override fun searchByIsbn(isbn: String): Flow<SearchResponse> {
        return flow {
            val response = raktenApi.searchByIsbn(isbn)
            emit(response)
        }
    }
}
