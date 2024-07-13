package com.yasser.worddictionary.activities.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yasser.common.presentation.navigation.RootNavigationEvent
import com.yasser.common.presentation.navigation.base.NavigationCoordinator
import com.yasser.common.presentation.theme.WordDictionaryTheme
import com.yasser.features.details.presentation.route.route.registerDetailsGraph
import com.yasser.features.search.presentation.route.SearchScreenRoute
import com.yasser.features.search.presentation.route.registerSearchGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    @Inject
    lateinit var rootNavigationEvent : NavigationCoordinator<RootNavigationEvent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordDictionaryTheme {
               val navController = rememberNavController()
                rootNavigationEvent.initNavControllers(navController)
                NavHost(
                    navController = navController,
                    startDestination = SearchScreenRoute.Search) {
                    registerSearchGraph()
                    registerDetailsGraph()
                }
            }
        }
    }

    override fun onDestroy() {
        rootNavigationEvent.releaseNavControllers()
        super.onDestroy()
    }
}
