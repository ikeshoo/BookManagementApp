package com.wings.android.bookmanagementapp.domain.ranking

import com.wings.android.bookmanagementapp.view.model.ranking.CategoryRanking
import kotlinx.coroutines.flow.Flow

interface GetRankingListUseCase {
    operator fun invoke(): Flow<List<CategoryRanking>>
}
