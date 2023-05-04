plugins {
    `kotlin-dsl`
}
dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.lint.detekt.gradle)
    implementation(libs.android.tools.buildgradle)
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
val rootDirProject = file("../")
