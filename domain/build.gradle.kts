plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.domain"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }
}
