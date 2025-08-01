plugins {
    alias(libs.plugins.dummyApp.application)
    alias(libs.plugins.dummyApp.compose)
    alias(libs.plugins.dummyApp.hilt)
    alias(libs.plugins.devtools.ksp)
}

val applicationName: String = libs.versions.applicationName.get()
val appId: String = libs.versions.applicationId.get()
val appVersion: String = libs.versions.versionName.get()
val compileSdk: String = libs.versions.compileSdk.get()
val versionCodeValue: Int = libs.versions.versionCode.get().toInt()

android {
    namespace = appId
    compileSdk = compileSdk

    defaultConfig {
        applicationId = appId
        minSdk = minSdk
        targetSdk = targetSdk
        versionCode = versionCode
        versionName = versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.android)

    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.coil.compose)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)

    implementation(projects.presentation)
    implementation(projects.domain)
    implementation(projects.data)
    implementation(projects.network)
}