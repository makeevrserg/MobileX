plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    targetHierarchy.default()
    // android
    androidTarget {
        publishLibraryVariants("release", "debug")
        publishLibraryVariantsGroupedByFlavor = true
    }
    // jvm
    jvm()
    // ios
    ios()
    iosSimulatorArm64()
}
android {
    namespace = "${libs.versions.project.group.get()}.servicelocator"
}
