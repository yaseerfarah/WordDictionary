package com.yasser.features.details.presentation.route.route

import kotlinx.serialization.Serializable

sealed class DetailsScreenRoute {
    @Serializable
    data class Details(val word: String) : DetailsScreenRoute()
}