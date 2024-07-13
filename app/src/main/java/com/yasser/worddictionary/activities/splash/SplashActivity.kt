package com.yasser.worddictionary.activities.splash

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.yasser.common.presentation.navigation.RootNavigationEvent
import com.yasser.common.presentation.navigation.base.NavigationCoordinator
import com.yasser.worddictionary.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var rootNavigationEvent : NavigationCoordinator<RootNavigationEvent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val splash = installSplashScreen()
        splash.setKeepOnScreenCondition { true }
        lifecycleScope.launch {
            delay(2000)
            rootNavigationEvent.handleNavigationEvent(RootNavigationEvent.NavigateFromSplashToHomeActivity(
                currentActivity = this@SplashActivity
            ))
        }

    }
}