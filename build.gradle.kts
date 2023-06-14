group = libs.versions.project.group
version = libs.versions.project.version

plugins {
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    id("detekt-convention")
    id("dokka-root")
}

tasks.register("cleanx", Delete::class) {
    delete(rootProject.buildDir)
}
