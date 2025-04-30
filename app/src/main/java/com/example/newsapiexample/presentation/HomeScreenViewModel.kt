package com.example.newsapiexample.presentation

import android.util.Log
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
    private val getEverythingUseCase: GetEverythingUseCase,
    private val topHeadlinesUseCase: TopHeadlinesUseCase
) : ViewModel(){

    private val _allArticles= MutableStateFlow<List<Article>>(emptyList())
    private val _topHeadlines= MutableStateFlow<List<Article>>(emptyList())
    val allArticles : StateFlow<List<Article>>
        get() = _allArticles
    val topHeadlines : StateFlow<List<Article>>
        get() = _topHeadlines

    init {
        //getEverything()
        topHeadlines()
    }
     private fun getEverything(){
        viewModelScope.launch {
            getEverythingUseCase.invoke().collect{
                _allArticles.value=it.articles
            }
        }
    }

    fun topHeadlines(category: String = ""){
        viewModelScope.launch {
            topHeadlinesUseCase.invoke(category).collect{
                _topHeadlines.value = it.articles
            }
        }
    }

}