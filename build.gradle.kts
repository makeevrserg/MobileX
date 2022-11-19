plugins {
    kotlin("android").version(Dependencies.Kotlin.version).apply(false)
    id("com.android.application").version(Dependencies.Android.androidAppliaction).apply(false)
    id("com.android.library").version(Dependencies.Android.androidLibrary).apply(false)
    id("org.jetbrains.compose").version(Dependencies.Compose.composeJetbrains).apply(false)
    kotlin("multiplatform").version(Dependencies.Kotlin.version).apply(false)
    kotlin("jvm").version(Dependencies.Kotlin.version).apply(false)
}

tasks.register("cleanx", Delete::class) {
    delete(rootProject.buildDir)
}