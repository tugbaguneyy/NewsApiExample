package com.example.newsapiexample.presentation.detail.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsapiexample.utils.cleanContent

@Composable
fun ArticleContent(content: String?, url: String?, context: Context) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = content?.cleanContent() ?: "",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()
        )

        url?.let { articleUrl ->
            TextButton(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(articleUrl))
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 0.dp)
            ) {
                Text("Read full article", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}