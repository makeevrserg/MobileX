pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://plugins.gradle.org/m2/")
        jcenter()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        maven("https://plugins.gradle.org/m2/")
        jcenter()
    }
}
rootProject.name = "MobileX"
include(":app")
include(":core")
include(":core-compose")
include(":ktx-core")
