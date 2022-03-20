package com.wings.android.bookmanagementapp.data.source.remote

import com.wings.android.bookmanagementapp.data.source.remote.entity.RankingResponse
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
}
