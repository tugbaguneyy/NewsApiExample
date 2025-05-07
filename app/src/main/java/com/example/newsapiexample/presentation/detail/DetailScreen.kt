package com.example.newsapiexample.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.newsapiexample.presentation.detail.components.ArticleDetailContent
import com.example.newsapiexample.presentation.detail.components.NoArticleSelected
import com.example.newsapiexample.ui.SharedViewModel


@Composable
fun DetailScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val article by sharedViewModel.selectedArticle.collectAsStateWithLifecycle()

    if (article == null) {
        NoArticleSelected(navController)
        return
    }

    ArticleDetailContent(article = article)
}













