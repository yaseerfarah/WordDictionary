package com.yasser.worddictionary.navigation

import android.app.Activity
import android.content.Intent
import androidx.navigation.NavHostController
import com.yasser.common.presentation.navigation.RootNavigationEvent
import com.yasser.common.presentation.navigation.base.NavigationCoordinator
import com.yasser.features.details.presentation.route.route.DetailsScreenRoute
import com.yasser.worddictionary.activities.home.HomeActivity
import javax.inject.Inject

class RootNavigationCoordinator @Inject constructor(

) : NavigationCoordinator<RootNavigationEvent>() {

    override fun handleNavigationEvent(event: RootNavigationEvent) {
        when (event){
            is RootNavigationEvent.NavigateFromSplashToHomeActivity -> navigateFromSplashToHomeActivity(event.currentActivity)
            is RootNavigationEvent.NavigateFromSearchScreenToDetailsScreen -> navController?.navigate(DetailsScreenRoute.Details(event.word))
            RootNavigationEvent.NavigateBack -> navController?.navigateUp()
        }
    }



    private fun navigateFromSplashToHomeActivity(activity: Activity) {
        val intent = Intent(activity, HomeActivity::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

}