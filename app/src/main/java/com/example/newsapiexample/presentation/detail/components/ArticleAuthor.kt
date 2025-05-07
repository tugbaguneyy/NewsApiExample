package com.example.newsapiexample.presentation.detail.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp


@Composable
fun ArticleAuthor(author: String?) {
    author?.takeIf { it.isNotBlank() }?.let { authorName ->
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Author: $authorName",
            style = MaterialTheme.typography.bodySmall,
            fontStyle = FontStyle.Italic
        )
    }
}