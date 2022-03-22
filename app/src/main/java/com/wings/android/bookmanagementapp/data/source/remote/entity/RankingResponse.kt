package com.wings.android.bookmanagementapp.data.source.remote.entity

import com.wings.android.bookmanagementapp.extension.formatRankingTitle
import com.wings.android.bookmanagementapp.extension.toHttps
import com.wings.android.bookmanagementapp.view.model.ranking.CategoryRanking
import com.wings.android.bookmanagementapp.view.model.ranking.RankingBook
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RankingResponse(
    @SerialName("Items")
    val items: List<Ranking>,
    val lastBuildDate: String,
    val title: String
) {
    fun toCategoryRanking(): CategoryRanking {
        return CategoryRanking(
            name = title.formatRankingTitle(),
            items = items.map { ranking ->
                RankingBook(
                    name = ranking.itemName,
                    rank = ranking.rank.toString(),
                    imageUlr = ranking.mediumImageUrls.firstOrNull()?.toHttps()
                )
            }
        )
    }
}
