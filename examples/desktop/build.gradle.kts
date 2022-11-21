import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val commonMain by getting{

            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Dependencies.Kotlin.coroutines}")
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
                implementation("ru.astrainteractive.mobilex:ktx-core:${Dependencies.versionDep}")
                implementation("ru.astrainteractive.mobilex:core-compose:${Dependencies.versionDep}")
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
