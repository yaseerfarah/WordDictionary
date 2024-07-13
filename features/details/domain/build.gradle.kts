plugins {
    Domain_module_plugin
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    sharedDependencies()
    implementation(project(Common.DOMAIN))
}