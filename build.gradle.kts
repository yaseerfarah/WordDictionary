plugins {
    kotlin("plugin.serialization") version "1.9.24" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false

}


buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        plugins()
    }
}



allprojects {

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions.freeCompilerArgs.addAll(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:experimentalStrongSkipping=true",
        )
    }

}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}