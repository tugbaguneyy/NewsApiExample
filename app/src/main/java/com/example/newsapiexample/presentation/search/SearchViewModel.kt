package com.example.newsapiexample.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapiexample.domain.model.Article
import com.example.newsapiexample.domain.usecase.GetEverythingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getEverythingUseCase: GetEverythingUseCase
) : ViewModel() {
    private val _allArticles = MutableStateFlow<List<Article>>(emptyList())
    val allArticles: StateFlow<List<Article>> = _allArticles.asStateFlow()


    fun getEverything(query: String) {
        if (query.isBlank()) return

        viewModelScope.launch {
                getEverythingUseCase.invoke(query).collect { response ->
                    _allArticles.value = response.articles ?: emptyList()
                }
        }
    }
}