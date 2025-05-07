package com.example.newsapiexample.presentation.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.newsapiexample.domain.model.Article
import com.example.newsapiexample.presentation.detail.components.ArticleDetailContent
import com.example.newsapiexample.ui.SharedViewModel
import com.example.newsapiexample.presentation.detail.components.NoArticleSelected
import com.example.newsapiexample.utils.cleanContent
import com.example.newsapiexample.utils.formatDate


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

    ArticleDetailContent(article = article, navController = navController)
}













