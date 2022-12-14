group = libs.versions.group
version = libs.versions.version

plugins {
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
}

tasks.register("cleanx", Delete::class) {
    delete(rootProject.buildDir)
}
