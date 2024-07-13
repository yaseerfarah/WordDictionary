package com.yasser.common.presentation.navigation.entrypoint

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.yasser.common.presentation.navigation.RootNavigationEvent
import com.yasser.common.presentation.navigation.base.NavigationCoordinator
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent


@EntryPoint
@InstallIn(SingletonComponent::class)
interface NavigationCoordinatorEntryPoint {
    fun rootNavigationCoordinator(): NavigationCoordinator<RootNavigationEvent>
}


@Composable
fun getRootNavigationCoordinator(): NavigationCoordinator<RootNavigationEvent> {
    val application = LocalContext.current.applicationContext
    return remember {
        EntryPointAccessors.fromApplication(
            application,
            NavigationCoordinatorEntryPoint::class.java
        ).rootNavigationCoordinator()
    }


}