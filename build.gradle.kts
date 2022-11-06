plugins {
    id("com.android.application").version(Dependencies.Android.androidAppliaction).apply(false)
    id("com.android.library").version(Dependencies.Android.androidLibrary).apply(false)
    id("org.jetbrains.kotlin.android").version(Dependencies.Kotlin.version).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}