buildscript{
    dependencies{
        classpath (libs.hilt.android.gradle.plugin)
        classpath (libs.gradle)
        classpath (libs.hilt.android.gradle.plugin.v2561)
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}