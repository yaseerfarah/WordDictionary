package com.yasser.features.search.presentation.route

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yasser.features.search.presentation.screens.search.view.SearchScreen


fun NavGraphBuilder.registerSearchGraph() {
    composable<SearchScreenRoute.Search>{
        SearchScreen()
    }
}