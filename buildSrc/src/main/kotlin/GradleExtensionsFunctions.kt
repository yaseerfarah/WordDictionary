import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

fun DependencyHandler.ksp(depName: String) {
    add("ksp", depName)
}
fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

fun DependencyHandler.compileOnly(depName: Dependency) {
    add("compileOnly", depName)
}

fun DependencyHandler.implementation(depName: Dependency) {
    add("implementation", depName)
}

fun DependencyHandler.classpath(depName: String) {
    add("classpath", depName)
}

fun DependencyHandler.androidTestImplementation(depName: Dependency) {
    add("androidTestImplementation", depName)
}

fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

fun DependencyHandler.testRuntimeOnly(depName: String) {
    add("testRuntimeOnly", depName)
}

fun DependencyHandler.PRODHUAWEIImplementation(depName: String) {
    add("PRODHUAWEIImplementation", depName)
}