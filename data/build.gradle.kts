plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    kotlin("kapt")
}

android {
    namespace = "dev.ru.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.negotiation)
    implementation(libs.ktor.client.serialization.json)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}