buildscript {
    dependencies {
        classpath("ru.astrainteractive.gradleplugin:convention:0.0.10")
        classpath("ru.astrainteractive.gradleplugin:android:0.0.10")
    }
}

plugins {
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}

apply(plugin = "ru.astrainteractive.gradleplugin.dokka.root")
apply(plugin = "ru.astrainteractive.gradleplugin.detekt")
apply(plugin = "ru.astrainteractive.gradleplugin.root.info")

subprojects.forEach {
    it.apply(plugin = "ru.astrainteractive.gradleplugin.dokka.module")
    it.apply(plugin = "ru.astrainteractive.gradleplugin.publication")
    it.apply(plugin = "ru.astrainteractive.gradleplugin.stub.javadoc")
    it.plugins.withId("org.jetbrains.kotlin.jvm") {
        it.apply(plugin = "ru.astrainteractive.gradleplugin.java.core")
    }
    it.plugins.withId("com.android.library") {
        it.apply(plugin = "ru.astrainteractive.gradleplugin.android.core")
    }
}

tasks.register("cleanx", Delete::class) {
    delete(rootProject.buildDir)
}
