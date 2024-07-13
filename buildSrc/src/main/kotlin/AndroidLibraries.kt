import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.sharedDependencies() {
    implementation(Hilt.hiltCore)
    kapt(Hilt.hiltCompiler)
    implementation(Coroutines.coroutinesCore)
    implementation(Utils.gson)

    // Testing dependencies
    testImplementation(Test.junitTest)
    testImplementation(Test.mockkTest)
    testImplementation(Test.coreTest)
    testImplementation(Test.turbineTestLibrary)
    testImplementation(Test.jsonTest)
    testImplementation(Test.coroutineTest)
    testImplementation(Test.mokitoTest)
}

fun DependencyHandler.dataDependencies() {
    implementation(Retrofit.retrofit)
    implementation(Retrofit.retrofitGsonConverter)
    implementation(Retrofit.retrofitScalarsConverter)
    implementation(Retrofit.okhttp)
    implementation(Retrofit.okhttpLogger)
    implementation(Room.roomRunTime)
    kapt(Room.roomCompiler)
    implementation(Room.roomKTX)
    implementation(DataStore.dataStore)
    implementation(Hilt.hiltAndroid)
    implementation(Coroutines.coroutinesAndroid)
    sharedDependencies()
}

fun DependencyHandler.presentationDependencies() {
    implementation(AndroidUI.activityCompose)
    implementation(AndroidUI.composeBom)
    implementation(AndroidUI.ui)
    implementation(AndroidUI.uiGraphics)
    implementation(AndroidUI.uiTooling)
    implementation(AndroidUI.uiToolingPreview)
    implementation(AndroidUI.material3)
    implementation(AndroidUI.navigationCompose)
    implementation(AndroidUI.coilCompose)
    implementation(AndroidUI.composeHiltViewModel)
    implementation(AndroidUI.splashScreen)
    implementation(AndroidUI.kotlinx_Serialization)
    implementation(Lifecycle.viewModelCompose)
    implementation(Lifecycle.lifecycleRuntime)
    implementation(Lifecycle.lifecycleViewModel)
    implementation(Hilt.hiltAndroid)
    implementation(Coroutines.coroutinesAndroid)
    sharedDependencies()
}


object AndroidUI {
    const val activityCompose = "androidx.activity:activity-compose:1.8.0"
    const val composeBom = "androidx.compose:compose-bom:2024.04.01"
    const val ui = "androidx.compose.ui:ui"
    const val uiGraphics = "androidx.compose.ui:ui-graphics"
    const val uiTooling = "androidx.compose.ui:ui-tooling"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3:1.2.1"
    const val navigationCompose = "androidx.navigation:navigation-compose:2.8.0-beta05"
    const val coilCompose = "io.coil-kt:coil-compose:2.4.0"
    const val splashScreen = "androidx.core:core-splashscreen:1.0.1"
    const val composeHiltViewModel = "androidx.hilt:hilt-navigation-compose:1.2.0"
    const val kotlinx_Serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1"

}


object Lifecycle {
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"


}


object Hilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:2.51.1"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:2.51.1"
    const val hiltCore = "com.google.dagger:hilt-core:2.51.1"


}


object Coroutines {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1"


}

object Room {
    const val roomRunTime = "androidx.room:room-runtime:2.6.1"
    const val roomCompiler = "androidx.room:room-compiler:2.6.1"
    const val roomKTX = "androidx.room:room-ktx:2.6.1"

}

object DataStore {
    const val dataStore = "androidx.datastore:datastore-preferences:1.0.0"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:2.11.0"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:2.11.0"
    const val retrofitScalarsConverter = "com.squareup.retrofit2:converter-scalars:2.11.0"
    const val okhttp = "com.squareup.okhttp3:okhttp:4.12.0"
    const val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:4.12.0"


}

object Utils {
    const val gson = "com.google.code.gson:gson:2.11.0"


}

object Test {
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:4.12.0"
    const val junitTest = "junit:junit:4.13.2"
    const val mockkTest = "io.mockk:mockk:1.12.0"
    const val coreTest = "androidx.arch.core:core-testing:2.1.0"
    const val AndroidJunitTest = "androidx.test.ext:junit:1.1.5"
    const val turbineTestLibrary = "app.cash.turbine:turbine:1.1.0"
    const val jsonTest = "org.json:json:20240303"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1"
    const val mokitoTest = "org.mockito:mockito-core:3.12.4"


}

