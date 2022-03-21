package com.wings.android.bookmanagementapp.view.ui.ranking

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.wings.android.bookmanagementapp.view.model.ranking.CategoryRanking
import com.wings.android.bookmanagementapp.view.model.ranking.RankingBook

// ToDo: 細かいレイアウトは後で修正する
@Composable
fun RankingColumn(rankings: List<CategoryRanking>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(rankings) { ranking ->
            Column() {
                Text(text = ranking.name)
                RankingRow(books = ranking.items)
            }
        }
    }
}

@Composable
fun RankingRow(books: List<RankingBook>) {
    LazyRow(
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(books) { book ->
            RankingItem(item = book)
        }
    }
}

@Composable
fun RankingItem(item: RankingBook) {
    Card(
        modifier = Modifier
            .wrapContentWidth()
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                painter = rememberAsyncImagePainter(item.imageUlr),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )

            val textModifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            Text(
                modifier = textModifier,
                text = item.name
            )
            Text(
                modifier = textModifier,
                text = item.rank
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRankingColumn() {
    RankingColumn(rankings = emptyList())
}

@Preview(showBackground = true)
@Composable
fun PreviewRankingRow() {
    RankingRow(books = emptyList())
}

@Preview(showBackground = true)
@Composable
fun PreviewRankingItem() {
    RankingItem(
        item = RankingBook(
            name = "name",
            rank = "rank",
            imageUlr = "imageUrl"
        )
    )
}
