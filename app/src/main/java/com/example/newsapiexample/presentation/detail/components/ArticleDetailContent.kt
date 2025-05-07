package com.example.newsapiexample.presentation.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.newsapiexample.domain.model.Article

@Composable
fun ArticleDetailContent(
    article: Article?
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            ArticleImage(article?.urlToImage)
            ArticleTitle(article?.title)
            ArticleMetadata(article?.source?.name, article?.publishedAt)
            ArticleDescription(article?.description)
            ArticleContent(article?.content, article?.url, context)
            ArticleAuthor(article?.author)
        }
    }
}