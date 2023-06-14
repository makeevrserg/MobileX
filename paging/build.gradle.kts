@file:Suppress("UnusedPrivateMember")

plugins {
    id("kmm-library-convention")
    id("convention.publication")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
            }
        }
    }
}
android {
    namespace = "${libs.versions.project.group.get()}.paging"
}
