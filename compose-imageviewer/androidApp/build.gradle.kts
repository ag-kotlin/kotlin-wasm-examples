import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "org.jetbrains.Imageviewer"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

//tasks.withType<KotlinJvmCompile>().configureEach {
//    val kotlinVersion = project.property("kotlin.version") as String
//    kotlinOptions.freeCompilerArgs += listOf(
//        // With decoys disabled, we have IdSignature clashes,
//        // so disable signature-clash-checks (decoys are going to be removed in the future )
////        "-Xklib-enable-signature-clash-checks=false",
//        "-P", "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=$kotlinVersion",
////        "-Xskip-prerelease-check",
////        "-Xpartial-linkage=enable",
//    )
//}

val composeVersion = project.property("compose.version") as String
compose.kotlinCompilerPlugin.set(composeVersion)