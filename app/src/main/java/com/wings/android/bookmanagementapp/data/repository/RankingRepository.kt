package com.wings.android.bookmanagementapp.data.repository

import com.wings.android.bookmanagementapp.data.source.remote.entity.RankingResponse
import kotlinx.coroutines.flow.Flow


interface RankingRepository {

    fun getRanking(genreId: Long): Flow<RankingResponse>
}
