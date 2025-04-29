package com.example.newsapiexample.data.remote

import com.example.newsapiexample.domain.model.Root
import com.example.newsapiexample.utils.Constants
import com.example.newsapiexample.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query: String = Constants.QUERY,
        @Query("apiKey") apiKey: String = API_KEY,
    ) : Root

    @GET("v2/top-headlines")
    suspend fun topHeadlines(
        @Query("country") country: String = "us",
        //@Query("category") category: String = "health",
        @Query("apiKey") apiKey: String = API_KEY,
    ) : Root

}