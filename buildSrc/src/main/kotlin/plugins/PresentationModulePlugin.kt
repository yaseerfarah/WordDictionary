package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class PresentationModulePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("androidx.navigation.safeargs.kotlin")
                apply("kotlin-kapt")
                apply("kotlin-parcelize")
                apply("kotlinx-serialization")
                apply("dagger.hilt.android.plugin")
            }


        }
    }


}