import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.dummyapp.conventions"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {

    plugins {
        register("dummyAppAndroidApplication") {
            id = "dummyApp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("dummyAppAndroidLibrary") {
            id = "dummyApp.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("dummyAppJavaLibrary") {
            id = "dummyApp.java.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("dummyAppCompose") {
            id = "dummyApp.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("dummyAppHilt") {
            id = "dummyApp.hilt"
            implementationClass = "HiltConventionPlugin"
        }
    }
}
