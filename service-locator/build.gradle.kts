
plugins {
    id("kmm-library-convention")
    id("convention.publication")
}

android {
    namespace = "${libs.versions.library.group.get()}.servicelocator"
}

