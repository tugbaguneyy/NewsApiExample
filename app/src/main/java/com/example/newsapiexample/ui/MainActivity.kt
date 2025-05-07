package com.example.newsapiexample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsapiexample.navigation.NavigationGraph
import com.example.newsapiexample.navigation.Screen
import com.example.newsapiexample.navigation.Screen.Home
import com.example.newsapiexample.ui.theme.MyappTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KClass

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyappTheme {
                val sharedViewModel: SharedViewModel = hiltViewModel()

                val navController = rememberNavController()
                val startDestination = Screen.Home
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                // Rota kontrolü için yardımcı fonksiyon
                fun isCurrentScreen(screen: KClass<out Screen>): Boolean {
                    return currentDestination?.hierarchy?.any {
                        it.route?.contains(screen.simpleName ?: "") == true
                    } == true
                }
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                            val title = when {
                                isCurrentScreen(Screen.Home::class) -> "News App"
                                isCurrentScreen(Screen.Detail::class) -> "Details"
                                isCurrentScreen(Screen.Search::class) -> "Search"
                                // Uygulamanızdaki diğer ekranları buraya ekleyebilirsiniz
                                else -> "Not Found"
                            }

                            CenterAlignedTopAppBar(
                                title = {
                                    Text(title)
                                },
                                navigationIcon = {
                                    if (!isCurrentScreen(Screen.Home::class)){
                                        IconButton(
                                            onClick = {
                                                navController.navigateUp()
                                            }
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.ArrowBack,
                                                contentDescription = "Back"
                                            )
                                        }
                                    }
                                },
                                actions = {
                                    if (isCurrentScreen(Screen.Home::class)) {
                                        IconButton(onClick = {
                                            navController.navigate(Screen.Search)
                                        }) {
                                            Icon(
                                                imageVector = Icons.Default.Search,
                                                contentDescription = "Search"
                                            )
                                        }
                                    }
                                },
                                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.secondary,
                                    titleContentColor = MaterialTheme.colorScheme.onSecondary,
                                    navigationIconContentColor = MaterialTheme.colorScheme.onSecondary,
                                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                                )
                            )

                    }
                    ) { innerPadding ->

                    NavigationGraph(
                        navController = navController,
                        startDestination = startDestination,
                        sharedViewModel = sharedViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}