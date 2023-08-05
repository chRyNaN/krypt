pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://repo.repsy.io/mvn/chrynan/public")
    }
}

plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.51.0"

    // See build.gradle.kts file in root project folder for the rest of the plugins applied.
}

rootProject.name = "krypt"

include(":krypt-core")
include(":krypt-uuid")
include(":krypt-csprng")
include(":krypt-encoding")
include(":krypt-hash")
include(":krypt-hash-argon")
include(":krypt-srp")
include(":krypt-jwt")
include(":krypt-otp")
include(":krypt-pkce")
