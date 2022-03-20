package com.wings.android.bookmanagementapp.view.ui.ranking

import android.util.Log
import com.wings.android.bookmanagementapp.data.repository.RankingRepository
import com.wings.android.bookmanagementapp.data.source.remote.entity.Ranking
import com.wings.android.bookmanagementapp.view.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RankingViewModel @Inject constructor(
    private val rankingRepository: RankingRepository
) : BaseViewModel() {

    private val _rankings = MutableStateFlow<List<Ranking>>(emptyList())
    val rankings: StateFlow<List<Ranking>>
        get() = _rankings

    fun getRankings(genreId: Long) {
        rankingRepository.getRanking(genreId).execute(
            onSuccess = {
                _rankings.value = it.items
            },
            retry = { getRankings(genreId) }
        )
    }
}
