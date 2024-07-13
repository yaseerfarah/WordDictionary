package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class DomainModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply {
                apply("java-library")
                apply("org.jetbrains.kotlin.jvm")
                apply("kotlin-kapt")
            }


        }
    }

}