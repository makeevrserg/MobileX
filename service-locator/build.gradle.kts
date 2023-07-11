plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    targetHierarchy.default()
    // android
    androidTarget()
    // jvm
    jvm()
    // ios
    ios()
    iosSimulatorArm64()
}
android {
    namespace = "${libs.versions.project.group.get()}.servicelocator"
}
