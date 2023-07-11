[![version](https://img.shields.io/maven-central/v/ru.astrainteractive.mobilex/ktx-core?style=flat-square)](https://github.com/makeevrserg/MobileX)
[![kotlin_version](https://img.shields.io/badge/kotlin-1.9.0-blueviolet?style=flat-square)](https://github.com/makeevrserg/MobileX)
[![platforms](https://img.shields.io/badge/platform-jvm%7Candroid%7Cios-blue?style=flat-square)](https://github.com/makeevrserg/MobileX)

# MobileX

Core library which I'm using in my projects - it helps to reduce boiler-plate code

## Docs
See docs page [here](docs/index.md) 

## Setup

Add a repository

```groovy
repositories {
    mavenCentral()
}
```

Add required modules to your module`s build.gradle file:

```groovy
dependencies {
    // This modules are ready to use
    implementation("ru.astrainteractive.mobilex:ktx-core:<version>")  // Android/Desktop/IOS
    implementation("ru.astrainteractive.mobilex:service-locator:<version>")  // Android/Desktop/IOS
    // This module is WIP, but ready to use
    implementation("ru.astrainteractive.mobilex:paging:<version>")  // Android/Desktop/IOS
    // I will not ever work with android views, but this module still here
    implementation("ru.astrainteractive.mobilex:rvadapter:<version>")  // Android
}
```

### Auto Documentation with dokka

```bash
./gradlew dokkaHtmlMultiModule
```