package com.example.newsapiexample.data.repository

import com.example.newsapiexample.data.remote.NewsApi
import com.example.newsapiexample.domain.model.Root
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsApiRepositoryImpl @Inject constructor(
    private val newsApi : NewsApi
){
    fun getEverything() : Flow<Root> = flow {
        val data = newsApi.getEverything()
        emit(data)
    }

    fun topHeadlines(category: String) : Flow<Root> = flow {
        val data = newsApi.topHeadlines(category=category)
        emit(data)
    }
}