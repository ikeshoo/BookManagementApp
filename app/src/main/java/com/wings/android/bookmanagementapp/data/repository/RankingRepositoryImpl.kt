package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.data.source.remote.RankingApi
import com.wings.android.bookmanagementapp.data.source.remote.entity.RankingResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val rankingApi: RankingApi
) : RankingRepository {

    override fun getRanking(genreId: Long): Flow<RankingResponse> {
        return flow {
            val response = rankingApi.fetchRanking(
                genreId = genreId
            )
            emit(response)
        }
    }
}
