import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.plugins() {
    classpath(ProjectGradlePlugins.gradlePlugin)
    classpath(ProjectGradlePlugins.kotlinPlugin)
    classpath(ProjectGradlePlugins.kotlinAllOpen)
    classpath(ProjectGradlePlugins.hilt)
    classpath(ProjectGradlePlugins.kotlinAndroidExtension)
    classpath(ProjectGradlePlugins.navigationSafeArgs)



}

object ProjectGradlePlugins {

    const val gradlePlugin = "com.android.tools.build:gradle:8.5.0"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.24"
    const val kotlinAllOpen = "org.jetbrains.kotlin:kotlin-allopen:1.9.24"
    const val kotlinAndroidExtension = "org.jetbrains.kotlin:kotlin-android-extensions:1.9.24"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:2.51.1"
}