plugins {
    `kotlin-dsl`
}
dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.lint.detekt.gradle)
    implementation(libs.android.tools.buildgradle)
    implementation(libs.dokka.android)
    implementation(libs.dokka.gradle.plugin)
    implementation(libs.dokka.core)
    implementation(libs.dokka.base)
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
val rootDirProject = file("../")
