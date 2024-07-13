package com.yasser.common.presentation.navigation.base

import androidx.navigation.NavHostController

abstract class NavigationCoordinator<Event> {

    protected var navController: NavHostController? = null

     fun initNavControllers(navController: NavHostController){
         this.navController = navController
     }

    fun releaseNavControllers(){
        navController = null
    }

    abstract fun handleNavigationEvent(event: Event)

}