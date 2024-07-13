package plugins

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.io.FileInputStream
import java.util.Properties

class DataModulePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("kotlin-kapt")
                apply("dagger.hilt.android.plugin")
            }

            val extension = extensions.getByName("android")
            if (extension is LibraryExtension) {
                extension.apply {
                    buildTypes.getByName("debug"){
                        buildConfigField("String", "BaseUrl", getServerPropertiesValue("BaseUrl"))
                    }

                    buildTypes.getByName("release"){
                        buildConfigField("String", "BaseUrl", getServerPropertiesValue("BaseUrl"))
                    }
                }

            }


        }
    }

    private fun getServerPropertiesValue(key: String): String {
        val properties = Properties()
        properties.load(FileInputStream(File( "server.properties")))
        return properties.getProperty(key)
    }

}