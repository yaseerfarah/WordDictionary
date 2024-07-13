package com.yasser.common.presentation.navigation

import android.app.Activity
import com.yasser.common.domain.entity.network.ResponseStatus

sealed interface RootNavigationEvent {

    data class NavigateFromSplashToHomeActivity(val currentActivity: Activity) : RootNavigationEvent

    data class NavigateFromSearchScreenToDetailsScreen(val word:String) : RootNavigationEvent

    data object NavigateBack : RootNavigationEvent
}