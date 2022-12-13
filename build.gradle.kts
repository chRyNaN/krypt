import com.chrynan.krypt.buildSrc.LibraryConstants

group = LibraryConstants.group
version = LibraryConstants.versionName

buildscript {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
        maven { url = uri("https://dl.bintray.com/chrynan/chrynan") }
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:1.7.20")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.7.21")
    }
}

apply(plugin = "org.jetbrains.dokka")

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }
}

rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.0.0"
}

// Documentation
tasks.named<org.jetbrains.dokka.gradle.DokkaMultiModuleTask>("dokkaGfmMultiModule").configure {
    outputDirectory.set(file("${projectDir.path}/docs"))
}
