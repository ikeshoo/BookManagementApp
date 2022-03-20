package com.wings.android.bookmanagementapp.view.ui.ranking

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

// ToDo: レイアウトは暫定。正しいものへ差し替える。
@Composable
fun RankingScreen(viewModel: RankingViewModel = hiltViewModel()) {
    viewModel.getRankings(101299L)
    val rankings by viewModel.rankings.collectAsState()

    LazyColumn() {
        items(rankings) { ranking ->
            Text(text = ranking.itemName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRankingScreen() {
    RankingScreen(hiltViewModel())
}
