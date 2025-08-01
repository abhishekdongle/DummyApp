plugins {
    id("kotlinx-serialization")
    alias(libs.plugins.dummyApp.android.library)
    alias(libs.plugins.dummyApp.hilt)
    kotlin("plugin.parcelize")
}

android {
    namespace = "com.domain"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
}
