package com.example.newsapiexample.domain.usecase

import com.example.newsapiexample.data.repository.NewsApiRepositoryImpl
import com.example.newsapiexample.domain.model.Root
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetEverythingUseCase @Inject constructor(
    private val newsApiRepositoryImpl: NewsApiRepositoryImpl
){
    operator fun invoke() : Flow<Root> = flow{
        newsApiRepositoryImpl.getEverything().collect{
            emit(it)
        }
    }
}