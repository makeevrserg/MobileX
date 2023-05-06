
plugins {
    id("kmm-library-convention")
    id("convention.publication")
}

android {
    namespace = "${libs.versions.project.group.get()}.servicelocator"
}
