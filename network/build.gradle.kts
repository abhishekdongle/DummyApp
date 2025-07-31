plugins {
    id("kotlinx-serialization")
    alias(libs.plugins.dummyApp.android.library)
    alias(libs.plugins.dummyApp.hilt)
}

android {
    namespace = "com.network"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
}
