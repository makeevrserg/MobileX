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
                implementation(project(":uitext:uitext-core"))
                api(libs.moko.resources.core)
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies{
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
    namespace = "com.makeevrserg.mobilex.utiext_mr"
}
