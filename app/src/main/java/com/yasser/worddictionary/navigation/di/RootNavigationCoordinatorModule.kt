package com.yasser.worddictionary.navigation.di

import com.yasser.common.presentation.navigation.RootNavigationEvent
import com.yasser.common.presentation.navigation.base.NavigationCoordinator
import com.yasser.worddictionary.navigation.RootNavigationCoordinator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RootNavigationCoordinatorModule {

    @Binds
    @Singleton
    abstract fun provideRootNavigationCoordinator(
        rootNavigationCoordinator: RootNavigationCoordinator
    ): NavigationCoordinator<RootNavigationEvent>

}