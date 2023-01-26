plugins {
    id("kmm-library-convention")
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlin.coroutines.core)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.google.android.material)
                implementation(libs.androidx.core.ktx)
            }
        }
        val jvmMain by getting {
            dependsOn(commonMain)
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }

}
android {
    namespace = "com.makeevrserg.mobilex.ktx_core"
    dependencies {
        implementation(libs.google.android.material)
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.androidx.constraintlayout.android)
        implementation(libs.androidx.cicerone)
        implementation(libs.androidx.fragment.ktx)
        implementation(libs.androidx.activity.ktx)
        implementation(libs.androidx.activity.core)
        implementation(libs.androidx.fragment.core)

        implementation(libs.kotlin.coroutines.core)
        implementation(libs.androidx.viewbinding)
        implementation(libs.androidx.lifecycle.viewModelKtx)
        implementation(libs.androidx.lifecycle.runtime)
        implementation(libs.androidx.fragment.ktx)
        implementation(libs.androidx.activity.ktx)
        implementation(libs.androidx.activity.core)
        implementation(libs.androidx.fragment.core)
    }
}
