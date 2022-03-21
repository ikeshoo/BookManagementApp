package com.wings.android.bookmanagementapp.domain.ranking

import com.wings.android.bookmanagementapp.data.repository.RankingRepository
import com.wings.android.bookmanagementapp.view.model.ranking.CategoryRanking
import com.wings.android.bookmanagementapp.view.model.ranking.RankingId
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetRankingListUseCaseImpl @Inject constructor(
    private val repository: RankingRepository
) : GetRankingListUseCase {
    override fun execute(): Flow<List<CategoryRanking>> {
        val idList = RankingId.values()
        val list = idList.map {
            repository.getRanking(it.id)
        }
        return combine(
            list[0],
            list[1],
            list[2]
        ) { t1, t2, t3 ->
            val ranking1 = t1.toCategoryRanking()
            val ranking2 = t2.toCategoryRanking()
            val ranking3 = t3.toCategoryRanking()

            listOf(
                ranking1,
                ranking2,
                ranking3
            )
        }
    }
}
