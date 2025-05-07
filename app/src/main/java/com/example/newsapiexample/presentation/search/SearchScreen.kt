package com.example.newsapiexample.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.newsapiexample.presentation.search.components.ArticleCard
import kotlinx.coroutines.delay

@Composable
fun SearchScreen(
) {
    val viewModel: SearchViewModel = hiltViewModel()

    var query by remember { mutableStateOf("") }

    val articles by viewModel.allArticles.collectAsStateWithLifecycle()

    LaunchedEffect(query) {
        if (query.isNotBlank()) {
            delay(300) // 300ms debounce time
            viewModel.getEverything(query)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                singleLine = true,
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
            )
        }

        when {
            query.isBlank() -> {
                Text(
                    text = "Please enter a search term.",
                    modifier = Modifier.padding(top = 32.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            articles.isEmpty() -> {
                Text(
                    text = "No results found",
                    modifier = Modifier.padding(top = 32.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            else -> {
                LazyColumn {
                    items(articles) { article ->
                        ArticleCard(article = article)
                    }
                }
            }
        }
    }
}
