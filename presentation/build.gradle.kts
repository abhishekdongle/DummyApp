plugins {
    id("kotlinx-serialization")
    alias(libs.plugins.dummyApp.android.library)
    alias(libs.plugins.dummyApp.hilt)
    alias(libs.plugins.dummyApp.compose)
}

android {
    namespace = "com.presentation"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)

    implementation(projects.domain)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.coil.compose)
    implementation(libs.androidx.material3)
    implementation(libs.hilt.android)
    implementation(libs.material3)
}
