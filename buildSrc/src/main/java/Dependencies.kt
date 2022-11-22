import org.gradle.api.JavaVersion

object Dependencies {

    const val version = "2.0.4"
    const val versionDep = "2.0.3"
    const val versionCode = 10
    const val compileSdkVersion = 33
    const val minSdkVersion = 21
    const val targetSdkVersion = 33
    const val buildTools = "7.2.2"
    const val group = "ru.astrainteractive.mobilex"
    object Kotlin {
        const val version = "1.7.10"
        const val coroutines = "1.6.4"
    }

    object Android {
        const val coreKTX = "1.9.0"
        const val androidxAppCompat = "1.4.0"
        const val androidMaterial = "1.5.0"
        const val viewBinding = "7.1.2"
        const val lifecycle = "2.6.0-alpha02"
        const val lifecycleViewModel = "2.5.1"
        const val constraintLayout = "2.1.2"
        const val cicerone = "7.1"
        const val androidAppliaction = "7.4.0-beta05"
        const val androidLibrary = "7.4.0-beta05"
    }

    object Testing {
        const val jUnit = "4.13.2"
        const val extJunit = "1.1.3"
        const val espressoCore = "3.4.0"
    }

    object Compose {
        const val composeJetbrains = "1.2.0"
        const val activityCompose = "1.5.1"
        const val composeMaterial = "1.2.1"
        const val composeAnimation = "1.2.1"
        const val composeUiTooling = "1.2.1"
        const val lifecycleViewModelCompose = "2.5.1"
        const val compose_kotlinCompilerExtensionVersion = "1.3.1"
    }

}