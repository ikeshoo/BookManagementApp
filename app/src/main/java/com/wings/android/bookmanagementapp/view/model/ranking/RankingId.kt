package com.wings.android.bookmanagementapp.view.model.ranking

import androidx.annotation.StringRes
import com.wings.android.bookmanagementapp.R

enum class RankingId(
    @StringRes
    val titleRes: Int,
    val id: Long
) {
    GENERAL(
        titleRes = R.string.ranking_id_general,
        id = 200162L
    ),
    NOVEL(
        titleRes = R.string.ranking_id_novel,
        id = 101266L
    ),
    COMIC(
        titleRes = R.string.ranking_id_comic,
        id = 101299L
    ),
    // ToDo: 一度に送れるリクエストが3つまでのため一旦コメントアウト
//    MAGAZINE(
//        titleRes = R.string.ranking_id_magazine,
//        id = 101302L
//    ),
//    LANGUAGE_STUDY(
//        titleRes = R.string.ranking_id_language_study,
//        id = 101293L
//    ),
//    QUALIFICATION(
//        titleRes = R.string.ranking_id_qualification,
//        id = 208663L
//    ),
//    PC(
//        titleRes = R.string.ranking_id_pc,
//        id = 101287L
//    ),
//    BUSINESS(
//        titleRes = R.string.ranking_id_business,
//        id = 200446
//    )
}
