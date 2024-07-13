plugins {
    id("org.jetbrains.kotlin.android")
    app_plugin
}

android {
    namespace = "com.yasser.worddictionary"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yasser.worddictionary"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kapt {
        correctErrorTypes = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    presentationDependencies()

    implementation(project(Common.DATA))
    implementation(project(Common.DOMAIN))
    implementation(project(Common.PRESENTATION))

    implementation(project(Features.SEARCH_DATA))
    implementation(project(Features.SEARCH_DOMAIN))
    implementation(project(Features.SEARCH_PRESENTATION))

    implementation(project(Features.DETAILS_DATA))
    implementation(project(Features.DETAILS_DOMAIN))
    implementation(project(Features.DETAILS_PRESENTATION))
}