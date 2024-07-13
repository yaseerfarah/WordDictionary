pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WordDictionary"
include(":app")
//Common
include(":common:data")
include(":common:domain")
include(":common:presentation")

//Features

//Search
include(":features:search:data")
include(":features:search:domain")
include(":features:search:presentation")

// Details
include(":features:details:presentation")
include(":features:details:data")
include(":features:details:domain")
