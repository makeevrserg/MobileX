import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                compileOnly(libs.kotlin.coroutines.core)
                // ByteString
                compileOnly("com.squareup.okio:okio:3.2.0")
            }
        }
        val jvmMain by getting {
            dependencies {
                compileOnly("com.squareup.okhttp3:okhttp:4.10.0")
                compileOnly("org.mongodb:mongo-java-driver:3.12.11")
            }
        }
        val androidMain by getting {
            dependsOn(jvmMain)
        }
    }

}
android {
    namespace = "$APPLICATION_ID.paging"
}
