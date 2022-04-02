package com.wings.android.bookmanagementapp.data.source.remote

import com.wings.android.bookmanagementapp.data.source.remote.entity.RankingResponse
import com.wings.android.bookmanagementapp.data.source.remote.entity.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RaktenApi {

    @GET("services/api/IchibaItem/Ranking/20170628/")
    suspend fun fetchRanking(
        @Query(value = "format") format: String = "json",
        @Query(value = "formatVersion") formatVersion: Int = 2,
        @Query(value = "carrier") carrire: Int = 1,
        @Query(value = "applicationId") applicationId: String ="1008739980345503296",
        @Query(value = "genreId") genreId: Long
    ): RankingResponse

    @GET("services/api/BooksBook/Search/20170404/")
    suspend fun searchByTitle(
        @Query(value = "title") title: String,
        @Query(value = "page") page: Int,
        @Query(value = "format") format: String = "json",
        @Query(value = "formatVersion") formatVersion: Int = 2,
        @Query(value = "carrier") carrire: Int = 1,
        @Query(value = "applicationId") applicationId: String ="1008739980345503296"
    ): SearchResponse

    @GET("services/api/BooksBook/Search/20170404/")
    suspend fun searchByIsbn(
        @Query(value = "isbnjan")  isbnCode: String,
        @Query(value = "page") page: Int = 1,
        @Query(value = "format") format: String = "json",
        @Query(value = "formatVersion") formatVersion: Int = 2,
        @Query(value = "carrier") carrire: Int = 1,
        @Query(value = "applicationId") applicationId: String ="1008739980345503296"
    ): SearchResponse
}
