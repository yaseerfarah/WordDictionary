package com.yasser.features.details.presentation.route.route

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.yasser.common.presentation.navigation.base.CustomNavType
import com.yasser.features.details.presentation.screens.details.view.DetailsScreen
import kotlin.reflect.typeOf


fun NavGraphBuilder.registerDetailsGraph() {
    composable<DetailsScreenRoute.Details>{

        DetailsScreen()
    }
}