package com.example.newsapiexample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapiexample.presentation.HomeScreen
import com.example.newsapiexample.presentation.detail.DetailScreen
import com.example.newsapiexample.presentation.search.SearchScreen
import com.example.newsapiexample.ui.SharedViewModel


@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    sharedViewModel: SharedViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<Screen.Home> {
            HomeScreen(navController,sharedViewModel)
        }

        composable<Screen.Detail> {
            DetailScreen(navController,sharedViewModel)
        }

        composable<Screen.Search> {
            SearchScreen()
        }
    }
}