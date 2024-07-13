plugins {
    data_module_plugin
}

android {
    namespace = "com.yasser.features.search.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    kapt {
        correctErrorTypes = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        buildConfig = true
    }
    kotlinOptions { jvmTarget = "17" }
}

dependencies {
    dataDependencies()
    implementation(project(Common.DATA))
    implementation(project(Features.SEARCH_DOMAIN))

}