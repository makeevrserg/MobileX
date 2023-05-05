

@file:Suppress("UnusedPrivateMember")

plugins {
    id("android-library-convention")
    id("convention.publication")
}

kotlin {
    sourceSets {
        val androidMain by getting {
            dependencies {
                // RecyclerView
                implementation(libs.android.recyclerview)
            }
        }
    }
}

android {
    namespace = "${libs.versions.library.group.get()}.rvadapter"
    buildFeatures.viewBinding = true
}
