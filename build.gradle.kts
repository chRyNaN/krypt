import com.chrynan.krypt.buildSrc.LibraryConstants

group = LibraryConstants.group
version = LibraryConstants.versionName

plugins {
    kotlin("jvm") version "1.9.0" apply false
    kotlin("multiplatform") version "1.9.0" apply false
    kotlin("android") version "1.9.0" apply false
    kotlin("plugin.serialization") version "1.9.0" apply false
    id("com.android.library") version "7.3.1" apply false
    id("com.android.application") version "7.3.1" apply false
    id("org.jetbrains.dokka") version "1.8.10"
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.13.2"
    id("com.mikepenz.aboutlibraries.plugin") version "10.8.3" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
    }
}

rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.0.0"
}

// Documentation
tasks.named<org.jetbrains.dokka.gradle.DokkaMultiModuleTask>("dokkaGfmMultiModule").configure {
    outputDirectory.set(file("${projectDir.path}/docs"))
}
