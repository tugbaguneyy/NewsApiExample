package com.example.newsapiexample.domain.usecase

import com.example.newsapiexample.data.repository.NewsApiRepositoryImpl
import com.example.newsapiexample.domain.model.Root
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopHeadlinesUseCase @Inject constructor(
private val newsApiRepositoryImpl: NewsApiRepositoryImpl
)
{
    operator fun invoke() : Flow<Root>{
        return newsApiRepositoryImpl.topHeadlines()
    }
}