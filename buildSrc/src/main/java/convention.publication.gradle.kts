import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.initialization.Environment
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing
import java.util.*

plugins {
    `maven-publish`
    signing
}

// Grabbing secrets from local.properties file or from environment variables, which could be used on CI
val secretPropsFile = project.rootProject.file(".gradle/gradle.properties")
val properties = Properties().apply { load(secretPropsFile.reader()) }
val signingKeyId = properties.getProperty("signing.keyId")
val signingPassword = properties.getProperty("signing.password")
val signingSecretKeyRingFile = properties.getProperty("signing.secretKeyRingFile")
val ossrhUsername = properties.getProperty("ossrhUsername")
val ossrhPassword = properties.getProperty("ossrhPassword")

ext["signing.keyId"] = signingKeyId
ext["signing.password"] = signingPassword
ext["signing.secretKeyRingFile"] = signingSecretKeyRingFile
ext["ossrhUsername"] = ossrhUsername
ext["ossrhPassword"] = ossrhPassword

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing {
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
    publications.withType<MavenPublication> {

        artifact(javadocJar.get())
        pom {
            name.set("MobileX")
            group = Dependencies.group
            version = Dependencies.version
            description.set("KMM library with frequently used code")
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

signing {
    sign(publishing.publications)
}