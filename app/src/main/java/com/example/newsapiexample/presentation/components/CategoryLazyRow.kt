package com.example.newsapiexample.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color

@Composable
fun CategoryLazyRow(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    val categories = listOf("general", "business", "entertainment", "health", "science", "sports", "technology")

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            OutlinedButton(
                onClick = { onCategorySelected(category) },
                border = BorderStroke(1.dp, if (selectedCategory == category) Color.Blue else Color.Gray)
            ) {
                Text(category.replaceFirstChar { it.uppercaseChar() })
            }
        }
    }
}
