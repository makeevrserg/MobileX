
pluginManagement {
    includeBuild("build-logic")
    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://plugins.gradle.org/m2/")
        maven("https://jitpack.io")
        gradlePluginPortal()
        mavenCentral()
        jcenter()
        google()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://plugins.gradle.org/m2/")
        maven("https://jitpack.io")
        gradlePluginPortal()
        mavenCentral()
        jcenter()
        google()
    }
}
rootProject.name = "MobileX"
// Examples
include(":examples:app")
include(":examples:desktop")
include(":examples:shared")
// Compose
include(":core-compose")
// KTX
include(":ktx-core")
// MVI
include(":mvi:mvi-core")
include(":mvi:mvi-moko")
// DI
include(":service-locator")
include(":paging")
// Adapter
include(":rvadapter")
// Sockets
//include(":rsocket")
// UIText
include(":uitext:uitext-core")
include(":uitext:uitext-mr")
include(":uitext:uitext-compose")