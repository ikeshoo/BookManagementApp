package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.data.source.remote.RaktenApi
import com.wings.android.bookmanagementapp.data.source.remote.entity.RankingResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RankingRepositoryImpl @Inject constructor(
    private val raktenApi: RaktenApi
) : RankingRepository {

    override fun getRanking(genreId: Long): Flow<RankingResponse> {
        return flow {
            val response = raktenApi.fetchRanking(
                genreId = genreId
            )
            emit(response)
        }
    }
}
