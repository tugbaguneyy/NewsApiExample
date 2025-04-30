package com.example.newsapiexample.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newsapiexample.presentation.components.ArticleCard
import com.example.newsapiexample.presentation.components.CategoryLazyRow

@Composable
fun HomeScreen(){

    val viewModel= hiltViewModel<HomeViewModel>()
    //val everythingArticles=viewModel.allArticles.collectAsStateWithLifecycle()
    val topHeadlineArticles=viewModel.topHeadlines.collectAsStateWithLifecycle()

    var selectedCategory by remember { mutableStateOf("general") }

    // Kategori değiştiğinde ilgili haberleri yükle
    LaunchedEffect(selectedCategory) {
        viewModel.topHeadlines(selectedCategory)
    }

    Column {
        CategoryLazyRow(
            selectedCategory,
            onCategorySelected = { selectedCategory = it }
        )
        LazyColumn(
            content = {
                items(topHeadlineArticles.value.size){
                    ArticleCard(topHeadlineArticles.value[it])
                }
            }
        )

}
}