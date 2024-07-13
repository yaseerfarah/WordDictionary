package com.yasser.features.search.presentation.route

import kotlinx.serialization.Serializable
@Serializable
sealed class SearchScreenRoute {
    @Serializable
    data object Search : SearchScreenRoute()
}