import ru.astrainteractive.gradleplugin.util.ProjectProperties.projectInfo

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    targetHierarchy.default()
    // android
    androidTarget()
    // jvm
    jvm()
    // ios
    ios()
    iosSimulatorArm64()
}
android {
    namespace = "${projectInfo.group}.servicelocator"
}
