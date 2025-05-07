package com.example.newsapiexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapiexample.domain.model.Article
import com.example.newsapiexample.domain.usecase.GetEverythingUseCase
import com.example.newsapiexample.domain.usecase.TopHeadlinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val topHeadlinesUseCase: TopHeadlinesUseCase
) : ViewModel(){

    private val _topHeadlines= MutableStateFlow<List<Article>>(emptyList())
    val topHeadlines : StateFlow<List<Article>>
        get() = _topHeadlines


    init {
        topHeadlines()
    }

    fun topHeadlines(category: String = ""){
        viewModelScope.launch {
            topHeadlinesUseCase.invoke(category).collect{
                _topHeadlines.value = it.articles
            }
        }
    }

}