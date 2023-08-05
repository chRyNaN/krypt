import com.chrynan.krypt.buildSrc.LibraryConstants
import com.chrynan.krypt.buildSrc.isBuildingOnLinux
import com.chrynan.krypt.buildSrc.isBuildingOnOSX
import com.chrynan.krypt.buildSrc.isBuildingOnWindows
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.dokka")
    id("maven-publish")
    kotlin("plugin.serialization")
}

group = LibraryConstants.group
version = LibraryConstants.versionName

kotlin {
    // Enable the default target hierarchy:
    targetHierarchy.default()

    jvm()

    js(IR) {
        browser()
        nodejs()
    }

    androidTarget()

    if (isBuildingOnOSX()) {
        ios()
        iosSimulatorArm64()
        tvos()
        watchos()
        macosX64()
        macosArm64()
    }

    if (isBuildingOnLinux()) {
        linuxX64()
    }

    if (isBuildingOnWindows()) {
        mingwX64()
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
        val commonMain by getting {
            dependencies {
                implementation(project(":krypt-core"))
                implementation(project(":krypt-hash"))
                implementation(project(":krypt-encoding"))

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:_")

                implementation(KotlinX.datetime)
            }
        }
        val jvmMain by getting {
            dependencies {
                compileOnly("io.jsonwebtoken:jjwt-api:_")
                implementation("io.jsonwebtoken:jjwt-impl:_")
                implementation("org.bouncycastle:bcprov-jdk15on:_")
            }
        }
    }
}

// Android Dependencies
dependencies {
    implementation("io.jsonwebtoken:jjwt-api:_")
    implementation("io.jsonwebtoken:jjwt-impl:_")
    runtimeOnly("io.jsonwebtoken:jjwt-orgjson:_") {
        exclude(group = "org.json", module = "json")
    }
    runtimeOnly("org.bouncycastle:bcprov-jdk15on:_")
}

android {
    compileSdk = LibraryConstants.Android.compileSdkVersion
    buildToolsVersion = LibraryConstants.Android.buildToolsVersion

    defaultConfig {
        minSdk = LibraryConstants.Android.minSdkVersion
        targetSdk = LibraryConstants.Android.targetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("lib-proguard-rules.txt")
    }

    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf(
                "-Xopt-in=kotlin.RequiresOptIn"
            )
        }
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].java.srcDirs("src/androidMain/kotlin")
    sourceSets["main"].res.srcDirs("src/androidMain/res")

    sourceSets["test"].java.srcDirs("src/androidTest/kotlin")
    sourceSets["test"].res.srcDirs("src/androidTest/res")
}

tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.INHERIT }

afterEvaluate {
    publishing {
        repositories {
            maven {
                url = uri("https://repo.repsy.io/mvn/chrynan/public")

                credentials {
                    username = (project.findProperty("repsyUsername") ?: System.getenv("repsyUsername")) as? String
                    password = (project.findProperty("repsyToken") ?: System.getenv("repsyToken")) as? String
                }
            }
        }
    }
}
