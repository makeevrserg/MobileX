@file:Suppress("VariableNaming")

import gradle.kotlin.dsl.accessors._9a33c1b87debd34fc7734fd23358d5b5.kotlin
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.registering
import org.gradle.kotlin.dsl.signing
import org.gradle.kotlin.dsl.withType
import java.util.*

plugins {
    `maven-publish`
    signing
}

// Grabbing secrets from local.properties file or from environment variables, which could be used on CI
val properties = Properties().apply {
    val secretPropsFile = project.rootProject.file("local.properties")
    if (secretPropsFile.exists()) {
        load(secretPropsFile.reader())
    }
}

val SIGNING_KEY_ID = System.getenv("SIGNING_KEY_ID") ?: properties.getProperty("signing.keyId")

val SIGNING_PASSWORD = System.getenv("SIGNING_PASSWORD") ?: properties.getProperty("signing.password")

val OSSRH_USERNAME = System.getenv("OSSRH_USERNAME") ?: properties.getProperty("ossrhUsername")

val OSSRH_PASSWORD = System.getenv("OSSRH_PASSWORD") ?: properties.getProperty("ossrhPassword")

val SIGNING_KEY = System.getenv("SIGNING_KEY") ?: properties.getProperty("signing.base64")

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}
kotlin {
    android {
        publishLibraryVariants("release", "debug")
        publishLibraryVariantsGroupedByFlavor = true
    }
}

publishing {
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = OSSRH_USERNAME
                password = OSSRH_PASSWORD
            }
        }
    }
    publications.withType<MavenPublication> {

        artifact(javadocJar.get())
        pom {
            name.set(libs.versions.project.name.get())
            group = libs.versions.project.group.get()
            version = libs.versions.project.version.string.get()
            description.set(libs.versions.project.description.get())
            url.set("https://github.com/makeevrserg/MobileX")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://github.com/makeevrserg/MobileX/blob/main/LICENSE.md")
                }
            }
            developers {
                developer {
                    id.set("makeevrserg")
                    name.set("Roman Makeev")
                    email.set("makeevrserg@gmail.com")
                }
            }
            scm {
                connection.set("scm:git:git:github.com/makeevrserg/MobileX.git")
                developerConnection.set("scm:git:ssh://github.com/makeevrserg/MobileX.git")
                url.set("https://github.com/makeevrserg/MobileX")
            }
        }
    }
}

tasks.create("Base64FromGPG") {
    val SIGNING_SECRET_KEY_RING_FILE = properties.getProperty("signing.secretKeyRingFile") ?: return@create
    val bytes = File(SIGNING_SECRET_KEY_RING_FILE).readBytes()

    val SIGNING_KEY = Base64.getEncoder().encodeToString(bytes)
    File("./key.txt").apply {
        if (!exists()) {
            createNewFile()
            writeText(SIGNING_KEY)
        }
    }
}

signing {
    useInMemoryPgpKeys(SIGNING_KEY_ID, SIGNING_KEY, SIGNING_PASSWORD)
    sign(publishing.publications)
}
