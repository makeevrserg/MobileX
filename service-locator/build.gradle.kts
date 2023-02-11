import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
    id("convention.publication")
}

android {
    namespace = "$APPLICATION_ID.di_container"
}

