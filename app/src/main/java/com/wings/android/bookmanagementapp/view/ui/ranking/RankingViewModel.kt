package com.wings.android.bookmanagementapp.view.ui.ranking

import com.wings.android.bookmanagementapp.domain.ranking.GetRankingListUseCase
import com.wings.android.bookmanagementapp.view.model.ranking.CategoryRanking
import com.wings.android.bookmanagementapp.view.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val getRankingListUseCase: GetRankingListUseCase
) : BaseViewModel() {

    private val _rankings = MutableStateFlow<List<CategoryRanking>>(emptyList())
    val rankings: StateFlow<List<CategoryRanking>>
        get() = _rankings

    fun getRankings() {
        getRankingListUseCase().execute(
            onSuccess = {
                _rankings.value = it
            },
            retry = { getRankings() }
        )
    }
}
