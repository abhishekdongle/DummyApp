plugins {
    id("kotlinx-serialization")
    alias(libs.plugins.dummyApp.android.library)
    alias(libs.plugins.dummyApp.hilt)
}

android {
    namespace = "com.presentation"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
}
