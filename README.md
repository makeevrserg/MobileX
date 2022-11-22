[![version](https://img.shields.io/maven-central/v/ru.astrainteractive.mobilex/ktx-core?style=flat-square)](https://github.com/makeevrserg/MobileX)
[![kotlin_version](https://img.shields.io/badge/kotlin-1.7.10-blueviolet?style=flat-square)](https://github.com/makeevrserg/MobileX)
[![platforms](https://img.shields.io/badge/platform-jvm%7Candroid-blue?style=flat-square)](https://github.com/makeevrserg/MobileX)
# MobileX
Core library which I'm using in my projects - it helps to reduce boiler-plate code

## Setup
Add a repository
```groovy
repositories {
  mavenCentral()
}
```
Add required modules to your module`s build.gradle file:
```groovy
dependencies{
  implementation("ru.astrainteractive.mobilex:android-core:<version>") // Android only
  implementation("ru.astrainteractive.mobilex:core-compose:<version>") // Android/Desktop
  implementation("ru.astrainteractive.mobilex:ktx-core:<version>")  // Android/Desktop/IOS
}
```

## [WIki](https://github.com/makeevrserg/MobileX/wiki)

## [Example](https://github.com/makeevrserg/MobileX/tree/master/examples)

