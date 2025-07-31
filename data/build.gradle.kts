plugins {
    id("kotlinx-serialization")
    alias(libs.plugins.dummyApp.android.library)
    alias(libs.plugins.dummyApp.hilt)
}

android {
    namespace = "com.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
}