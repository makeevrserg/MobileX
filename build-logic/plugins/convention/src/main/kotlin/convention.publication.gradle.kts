import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.signing
import org.gradle.kotlin.dsl.withType
import java.util.*

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.gradle.maven-publish")
    id("signing")
}
kotlin {
    android {
        publishAllLibraryVariants()
        publishLibraryVariantsGroupedByFlavor = true
    }
}
publishing {
    repositories.maven("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") {
        name = "OSSRH"

        credentials {
            username = System.getenv("OSSRH_USER")
            password = System.getenv("OSSRH_KEY")
        }
    }
    publications.withType<MavenPublication> {
        pom {
            name.set(libs.versions.library.name)
            description.set(libs.versions.library.description)
            url.set("https://github.com/makeevrserg/MobileX")

            group = libs.versions.library.group.get()
            version = libs.versions.library.version.string.get()

            licenses {
                license {
                    name.set("MIT")
                    distribution.set("repo")
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
    val signingKeyId: String? = System.getenv("SIGNING_KEY_ID")
    val signingPassword: String? = System.getenv("SIGNING_PASSWORD")
    val signingKey: String? = System.getenv("SIGNING_KEY")?.let { base64Key ->
        String(Base64.getDecoder().decode(base64Key))
    }
    if (signingKeyId != null) {
        useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
        sign(publishing.publications)
    }
}
