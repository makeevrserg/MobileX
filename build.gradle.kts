group = libs.versions.library.group
version = libs.versions.library.version

plugins {
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    id("detekt-convention")
}

tasks.register("cleanx", Delete::class) {
    delete(rootProject.buildDir)
}
