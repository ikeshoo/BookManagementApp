package com.wings.android.bookmanagementapp.view.ui.ranking

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

// ToDo: レイアウトは暫定。正しいものへ差し替える。
@Composable
fun RankingScreen(viewModel: RankingViewModel = hiltViewModel()) {
    val rankings by viewModel.rankings.collectAsState()
    LaunchedEffect(key1 = true) { viewModel.getRankings() }

    RankingColumn(rankings = rankings)
}

@Preview(showBackground = true)
@Composable
fun PreviewRankingScreen() {
    RankingScreen(hiltViewModel())
}
