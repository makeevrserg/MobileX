plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
    id("convention.publication")
}

group = Dependencies.group
version = Dependencies.version

kotlin {
    android(){
        publishLibraryVariants("release", "debug")
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }


    }
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../../iosApp/Podfile")
        framework {
            baseName = "CoreKTX"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependencies.Kotlin.coroutines}")
            }
        }
        val nonAndroidMain by creating {
            dependsOn(commonMain)
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core-ktx:${Dependencies.Android.coreKTX}")
            }
        }
        val jvmMain by getting {
            dependsOn(nonAndroidMain)

        }
        val iosX64Main by getting {
            dependsOn(nonAndroidMain)
        }
        val iosArm64Main by getting {
            dependsOn(nonAndroidMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(nonAndroidMain)
        }
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
    compileSdk = Dependencies.compileSdkVersion

    defaultConfig {
        minSdk = Dependencies.minSdkVersion
        targetSdk = Dependencies.targetSdkVersion
    }
    dependencies {
        implementation("androidx.core:core-ktx:${Dependencies.Android.coreKTX}")
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}
