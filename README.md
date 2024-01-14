# Clean Architecture - MVVM Urban Dictionary using Compose
Simple app to fetch words using Urban Dictionary API using Clean architecture and MVVM, and Jetpack Compose.

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-8.2.1-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-8.2-blue?style=flat)](https://gradle.org)

[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24)
[![status](https://github.com/gonzaloguzzardi/dictionary-app-compose/blob/main/.github/workflows/android_build.yml/badge.svg?branch=main)](https://github.com/gonzaloguzzardi/dictionary-app-compose/actions?query=branch%3Amain++)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)

Requires Android Studio Hedgehog

## Project characteristics
* 100% [Kotlin](https://kotlinlang.org/)
* Clean Architecture
* MVVM
* Flow
* [Jetpack Compose](https://developer.android.com/jetpack/compose)
* [Android Jetpack](https://developer.android.com/jetpack)
* [Dependency Injection](https://developer.android.com/training/dependency-injection)
* Reactive UI
* Testing (Unit, UI)
* Static analysis tools
* Material design
* Version Catalog

## Tech-stack

<img src="assets/app-preview.gif" width="300" align="right" hspace="20">

Min API level is set to [`24`](https://android-arsenal.com/api?level=24)

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) + [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html)- perform background operations
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [Jetpack Compose](https://developer.android.com/jetpack/compose)
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
* Architecture
    * Clean Architecture 
    * MVVM
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel))
* Dependency Injection
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) 
* Static analysis tools
    * [Detekt](https://detekt.dev/) + [Ktlint plugin](https://pinterest.github.io/ktlint/latest/) 
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/), [Mockito](https://site.mockito.org/))
* Gradle
    * [Detekt](https://github.com/arturbosch/detekt#with-gradle)
* Debugging
    * [LeakCanary](https://github.com/square/leakcanary)
* Dependency Management
    * [Version Catalog](https://developer.android.com/build/migrate-to-catalogs)

## Getting started
To open this project follow any of the next steps:
### Android Studio Hedgehog

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `https://github.com/gonzaloguzzardi/dictionary-app-compose.git` into URL field
3. Open secrets.properties file and set your [RapidApiKey](https://rapidapi.com/community/api/urban-dictionary/)

### Command-line + Android Studio Hedgehog

1. Run `git clone https://github.com/gonzaloguzzardi/dictionary-app-compose.git`
2. Android Studio -> File -> Open
3. Open secrets.properties file and set your [RapidApiKey](https://rapidapi.com/community/api/urban-dictionary/)
