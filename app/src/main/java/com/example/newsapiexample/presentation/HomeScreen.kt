package com.example.newsapiexample.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(){

    val viewModel= hiltViewModel<HomeViewModel>()

    val allArticles=viewModel.topHeadlines.collectAsStateWithLifecycle()

    LazyColumn(
        content = {
            items(allArticles.value.size){
                ArticleCard(allArticles.value[it])
            }
        }
    )
}