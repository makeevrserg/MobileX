import com.makeevrserg.mobilex.MobileXApk.APPLICATION_ID

plugins {
    id("kmm-library-convention")
}

android {
    namespace = "$APPLICATION_ID.di_container"
}

