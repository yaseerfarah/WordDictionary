package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.kotlin


class AppModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("androidx.navigation.safeargs.kotlin")
                apply("kotlin-kapt")
                apply("dagger.hilt.android.plugin")
            }


        }
    }


}