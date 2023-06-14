

@file:Suppress("UnusedPrivateMember")

plugins {
    id("kmm-library-convention")
    id("convention.publication")
    id("dokka-convention")
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
    namespace = "${libs.versions.project.group.get()}.rvadapter"
    buildFeatures.viewBinding = true
}
