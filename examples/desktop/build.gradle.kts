import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization")
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
//        withJava()
    }
    sourceSets {
        val commonMain by getting {

            dependencies {
                implementation(libs.kotlin.coroutines.core)
//                implementation(project(":rsocket"))
                implementation(project(":service-locator"))
                implementation(libs.kotlin.serialization.json)
            }
        }
        val jvmMain by getting {
            dependencies {
                // Compose
                implementation(compose.desktop.currentOs)
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.runtime)
                implementation(compose.materialIconsExtended)
                implementation(libs.mobileX.core.ktx)
                implementation(libs.mobileX.core.compose)

                implementation("com.squareup.okhttp3:okhttp:4.10.0")
                implementation("org.mongodb:mongo-java-driver:3.12.11")
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.makeevrserg.mobilex.desktop.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
            packageVersion = "1.0.0"
        }
    }
}
