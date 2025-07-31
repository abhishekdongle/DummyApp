import com.android.build.api.dsl.ApplicationExtension
import com.dummyapp.config.libs
import org.gradle.api.Plugin
import com.dummyapp.config.configureKotlinAndroid
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import com.dummyapp.config.ext.implementation
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(commonExtension = this)
                defaultConfig.targetSdk = libs.findVersion("compileSdk").get().toString().toInt()
            }

            dependencies {
                implementation(libs.findLibrary("kotlinx-serialization-json").get())
            }
        }
    }
}