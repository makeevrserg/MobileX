
plugins {
    id("kmm-library-convention")
    id("convention.publication")
    id("dokka-convention")
}

android {
    namespace = "${libs.versions.project.group.get()}.servicelocator"
}
