plugins {
    `kotlin-dsl`
}

gradlePlugin{
    plugins {
        register("app_plugin") {
            id = "app_plugin"
            implementationClass = "plugins.AppModulePlugin"
        }
    }
}

gradlePlugin{
    plugins {
        register("data_module_plugin") {
            id = "data_module_plugin"
            implementationClass = "plugins.DataModulePlugin"
        }
    }
}


gradlePlugin{
    plugins {
        register("Domain_module_plugin") {
            id = "Domain_module_plugin"
            implementationClass = "plugins.DomainModulePlugin"
        }
    }
}


gradlePlugin{
    plugins {
        register("Presentation_module_plugin") {
            id = "Presentation_module_plugin"
            implementationClass = "plugins.PresentationModulePlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}
val kotlinVersion = "1.9.24"
val gradleBuild = "8.5.0"
val javapoetVersion = "1.13.0"
dependencies {
    compileOnly(gradleKotlinDsl())
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:$gradleBuild")
    implementation("com.squareup:javapoet:$javapoetVersion")
    implementation(kotlin("gradle-plugin", version = kotlinVersion))
    implementation(kotlin("gradle-plugin-api", version = kotlinVersion))

}