buildscript{
    dependencies{

        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44")
        classpath ("com.android.tools.build:gradle:8.9.1")  // Check for the latest stable version
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.56.1")

    }
}


plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}